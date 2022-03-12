package dev.yashg.todoist.db

import dev.yashg.todoist.models.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<Task>>

    suspend fun getTaskById(id: Int): Task?

    suspend fun insertTask(task: Task)

    suspend fun deleteTask(task: Task)

    suspend fun getCompletedTasks(): Flow<List<Task>>

    suspend fun orderTasks(isAsc: Boolean): Flow<List<Task>>

    suspend fun searchTasks(query: String): Flow<List<Task>>
}
