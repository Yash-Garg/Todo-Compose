package dev.yashg.todoist.utils

import dev.yashg.todoist.db.TaskRepository
import dev.yashg.todoist.models.Task

class DeleteTask(private val repository: TaskRepository) {

    suspend operator fun invoke(task: Task) {
        return repository.deleteTask(task)
    }
}
