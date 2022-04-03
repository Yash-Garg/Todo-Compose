package dev.yashg.todoist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.navigation.compose.rememberNavController
import dev.yashg.todoist.ui.tasks.TasksScreen
import dev.yashg.todoist.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NotesAppTheme { TasksScreen(navController = navController) }
        }
    }
}
