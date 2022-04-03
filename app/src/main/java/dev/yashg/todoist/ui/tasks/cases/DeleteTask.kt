package dev.yashg.todoist.ui.tasks.cases

import dev.yashg.todoist.models.Task
import dev.yashg.todoist.repository.TaskRepository

class DeleteTask(private val repository: TaskRepository) {

    suspend operator fun invoke(task: Task) {
        return repository.deleteTask(task)
    }
}
