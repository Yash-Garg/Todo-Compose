package dev.yashg.todoist.models

import dev.yashg.todoist.ui.tasks.cases.AddTask
import dev.yashg.todoist.ui.tasks.cases.DeleteTask
import dev.yashg.todoist.ui.tasks.cases.GetTasks

data class TaskUseCases(val getTasks: GetTasks, val deleteTask: DeleteTask, val addTask: AddTask)
