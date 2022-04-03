package dev.yashg.todoist.models

import androidx.annotation.Keep
import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception

@Keep
@Entity
data class Task(
    @PrimaryKey val id: Int? = null,
    val timestamp: Long,
    val title: String,
    val content: String,
    val color: Int,
    val completed: Boolean = false
) {
    companion object {
        val noteColors = listOf(Color.Red, Color.Green, Color.Blue)
    }
}

class InvalidTaskException(message: String) : Exception(message)
