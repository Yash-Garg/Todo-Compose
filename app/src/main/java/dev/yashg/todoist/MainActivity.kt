package dev.yashg.todoist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.yashg.todoist.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NotesAppTheme { HomeScreen() } }
    }
}

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Home") }) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/},
                backgroundColor = Color.Red,
            ) { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
        }
    ) {}
}
