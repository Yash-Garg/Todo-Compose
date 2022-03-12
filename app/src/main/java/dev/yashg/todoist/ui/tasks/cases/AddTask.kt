package dev.yashg.todoist.ui.tasks.cases

import dev.yashg.todoist.repository.TaskRepository
import dev.yashg.todoist.models.InvalidTaskException
import dev.yashg.todoist.models.Task

class AddTask(private val repository: TaskRepository) {

    @Throws(InvalidTaskException::class)
    suspend operator fun invoke(task: Task) {
        when {
            task.title.isBlank() -> {
                throw InvalidTaskException("Task title cannot be empty.")
            }
            task.content.isBlank() -> {
                throw InvalidTaskException("Task content cannot be empty.")
            }
            else -> repository.insertTask(task)
        }
    }
}
