package dev.yashg.todoist.utils

import dev.yashg.todoist.db.TaskRepository
import dev.yashg.todoist.models.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTasks(private val repository: TaskRepository) {

    operator fun invoke(
        taskOrder: TaskOrder = TaskOrder.Date(OrderType.Descending)
    ): Flow<List<Task>> {
        return repository.getTasks().map { tasks ->
            when (taskOrder.orderType) {
                is OrderType.Ascending -> {
                    when (taskOrder) {
                        is TaskOrder.Title -> tasks.sortedBy { it.title }
                        is TaskOrder.Date -> tasks.sortedBy { it.timestamp }
                    }
                }
                is OrderType.Descending -> {
                    when (taskOrder) {
                        is TaskOrder.Title -> tasks.sortedByDescending { it.title }
                        is TaskOrder.Date -> tasks.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }
}
