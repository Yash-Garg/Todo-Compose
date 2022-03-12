package dev.yashg.todoist.ui.tasks.cases

import dev.yashg.todoist.repository.TaskRepository
import dev.yashg.todoist.models.Task

class DeleteTask(private val repository: TaskRepository) {

    suspend operator fun invoke(task: Task) {
        return repository.deleteTask(task)
    }
}
