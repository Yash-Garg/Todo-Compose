package dev.yashg.todoist.ui.tasks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun TasksScreen(
    navController: NavController,
    taskViewModel: TaskViewModel = viewModel(),
) {
    val state = taskViewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/},
                backgroundColor = MaterialTheme.colors.primary
            ) { Icon(imageVector = Icons.Default.Add, contentDescription = "Add Task") }
        }
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(60.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) { Text(text = "Your Tasks", style = MaterialTheme.typography.h4) }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.tasks) { task ->
                    TaskItem(
                        task = task,
                        modifier = Modifier.fillMaxWidth().clickable {},
                        onDelete = {
                            taskViewModel.onEvent(TasksEvent.DeleteTask(task = task))
                            scope.launch {
                                val choice =
                                    scaffoldState.snackbarHostState.showSnackbar(
                                        "Task deleted",
                                        actionLabel = "Undo"
                                    )
                                if (choice == SnackbarResult.ActionPerformed) {
                                    taskViewModel.onEvent(TasksEvent.RestoreTask)
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
