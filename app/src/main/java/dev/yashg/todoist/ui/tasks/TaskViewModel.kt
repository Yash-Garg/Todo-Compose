package dev.yashg.todoist.ui.tasks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yashg.todoist.models.Task
import dev.yashg.todoist.models.TaskUseCases
import dev.yashg.todoist.utils.OrderType
import dev.yashg.todoist.utils.TaskOrder
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class TaskViewModel @Inject constructor(private val taskUseCases: TaskUseCases) : ViewModel() {

    private val _state = mutableStateOf(TasksState())
    private val state: State<TasksState> = _state

    private var recentlyDeletedTask: Task? = null
    private var tasksJob: Job? = null

    init {
        getTasks(TaskOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: TasksEvent) {
        when (event) {
            is TasksEvent.DeleteTask -> {
                viewModelScope.launch { taskUseCases.deleteTask(event.task) }
            }
            is TasksEvent.Order -> {
                if (state.value.taskOrder::class == event.taskOrder::class &&
                        state.value.taskOrder.orderType == event.taskOrder.orderType
                ) {
                    return
                }
                getTasks(event.taskOrder)
            }
            is TasksEvent.RestoreTask -> {
                viewModelScope.launch {
                    taskUseCases.addTask(recentlyDeletedTask ?: return@launch)
                    recentlyDeletedTask = null
                }
            }
            is TasksEvent.ToggleOrderSection -> {
                _state.value =
                    state.value.copy(orderSelectionVisible = !state.value.orderSelectionVisible)
            }
        }
    }

    private fun getTasks(taskOrder: TaskOrder) {
        tasksJob?.cancel()
        tasksJob =
            taskUseCases
                .getTasks(taskOrder)
                .onEach { _state.value = state.value.copy(tasks = it, taskOrder = taskOrder) }
                .launchIn(viewModelScope)
    }
}
