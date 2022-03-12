package dev.yashg.todoist.db

import dev.yashg.todoist.models.Task
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(private val dao: TaskDao) : TaskRepository {
    override fun getTasks(): Flow<List<Task>> {
        return dao.getAllTasks()
    }

    override suspend fun getTaskById(id: Int): Task? {
        return dao.getTaskById(id)
    }

    override suspend fun insertTask(task: Task) {
        return dao.insertTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        return dao.deleteTask(task)
    }

    override suspend fun getCompletedTasks(): Flow<List<Task>> {
        return dao.getCompletedTasks()
    }

    override suspend fun searchTasks(query: String): Flow<List<Task>> {
        return dao.searchTasks(query)
    }
}
