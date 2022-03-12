package dev.yashg.todoist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.yashg.todoist.models.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract val taskDao: TaskDao

    companion object {
        const val DATABASE_NAME = "tasks_db"
    }
}
