package dev.yashg.todoist.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.yashg.todoist.db.TaskDatabase
import dev.yashg.todoist.db.TaskRepository
import dev.yashg.todoist.db.TaskRepositoryImpl
import dev.yashg.todoist.models.TaskUseCases
import dev.yashg.todoist.utils.AddTask
import dev.yashg.todoist.utils.DeleteTask
import dev.yashg.todoist.utils.GetTasks
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTaskDatabase(app: Application): TaskDatabase {
        return Room.databaseBuilder(app, TaskDatabase::class.java, TaskDatabase.DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(db: TaskDatabase): TaskRepository {
        return TaskRepositoryImpl(db.taskDao)
    }

    @Provides
    @Singleton
    fun provideTaskUseCases(repository: TaskRepository): TaskUseCases {
        return TaskUseCases(
            getTasks = GetTasks(repository),
            deleteTask = DeleteTask(repository),
            addTask = AddTask(repository)
        )
    }
}
