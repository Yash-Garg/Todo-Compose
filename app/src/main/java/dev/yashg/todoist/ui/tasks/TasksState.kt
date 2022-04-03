package dev.yashg.todoist.ui.tasks

import dev.yashg.todoist.models.Task
import dev.yashg.todoist.utils.OrderType
import dev.yashg.todoist.utils.TaskOrder

data class TasksState(
    val tasks: List<Task> = emptyList(),
    val taskOrder: TaskOrder = TaskOrder.Date(OrderType.Descending),
    val orderSelectionVisible: Boolean = false
)
