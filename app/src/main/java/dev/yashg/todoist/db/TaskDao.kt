package dev.yashg.todoist.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import dev.yashg.todoist.models.Task

@Dao
interface TaskDao {
    @Query("") fun saveTask(task: Task)

    @Query("SELECT * FROM task") fun getAllTasks(): List<Task>

    @Query("SELECT * FROM task WHERE completed is 1") fun getCompletedTasks(): List<Task>

    @Query(
        "SELECT * FROM task ORDER BY " +
            "CASE WHEN :isAsc = 1 THEN createdAt END ASC," +
            "CASE WHEN :isAsc = 0 THEN createdAt END DESC"
    )
    fun orderTasks(isAsc: Boolean): List<Task>

    @Query("SELECT * FROM task WHERE title LIKE :query") fun searchTasks(query: String): List<Task>

    @Delete fun delete(task: Task)
}
