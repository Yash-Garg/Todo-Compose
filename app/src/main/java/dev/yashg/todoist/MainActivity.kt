package dev.yashg.todoist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.yashg.todoist.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NotesAppTheme { HomeScreen() } }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "HomePage") }) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/},
                backgroundColor = Color.Red,
            ) { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
        }
    ) {
        ExpandableCard(
            title = "Card Title",
            subtitle =
                """Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                |Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
                |when an unknown printer took a galley of type and scrambled it to make a type 
                |specimen book.""",
            padding = 10.dp,
        )
    }
}
