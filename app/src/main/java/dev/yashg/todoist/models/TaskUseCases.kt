package dev.yashg.todoist.models

import dev.yashg.todoist.utils.AddTask
import dev.yashg.todoist.utils.DeleteTask
import dev.yashg.todoist.utils.GetTasks

data class TaskUseCases(val getTasks: GetTasks, val deleteTask: DeleteTask, val addTask: AddTask)
