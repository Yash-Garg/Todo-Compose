package dev.yashg.todoist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.OpenInNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
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
                    composable("home") { HomeScreen(navController) }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    val context = LocalContext.current
    TopAppBar(
        title = { Text("Welcome") },
        navigationIcon = {
            IconButton(onClick = {}) { Icon(Icons.Filled.Menu, contentDescription = null) }
        },
        actions = {
            IconButton(
                onClick = {
                    Toast.makeText(context, "Opening in browser", Toast.LENGTH_SHORT).show()
                }
            ) { Icon(Icons.Outlined.OpenInNew, contentDescription = null) }
        }
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(text = "Welcome to Compose!", fontSize = 23.sp, fontWeight = FontWeight.Bold)
        Button(
            modifier = Modifier.padding(8.dp),
            onClick = { navController.navigate("home") },
        ) { Text(text = "Go to home page", fontSize = 16.sp) }
    }
}
