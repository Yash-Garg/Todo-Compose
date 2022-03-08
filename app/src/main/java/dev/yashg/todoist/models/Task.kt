package dev.yashg.todoist.models

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Keep
@Entity
data class Task(
    @PrimaryKey val uid: Int,
    val createdAt: Date,
    val title: String,
    val completed: Boolean = false
)
