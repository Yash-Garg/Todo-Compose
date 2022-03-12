package dev.yashg.todoist.db

import androidx.room.*
import dev.yashg.todoist.models.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertTask(task: Task)

    @Delete suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM task") fun getAllTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE completed is 1")
    suspend fun getCompletedTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE id IS :id") suspend fun getTaskById(id: Int): Task?

    @Query("SELECT * FROM task WHERE title LIKE :query")
    suspend fun searchTasks(query: String): Flow<List<Task>>
}
