package dev.yashg.todoist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.yashg.todoist.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NotesAppTheme {
                NavHost(navController, startDestination = "home") {
                    composable("home") { HomeScreen() }
                    composable("login") { LoginScreen() }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
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

@Composable
fun LoginScreen() {
    Text("Login Screen")
}
