package com.yeditepe.finalexam.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.yeditepe.finalexam.model.Task
import com.yeditepe.finalexam.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(
    navController: NavController,
    viewModel: TaskViewModel = viewModel()
) {

    // TODO 3: Read task list from ViewModel
    val tasks = viewModel.tasks

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValus(16.dp)
        verticalArrangement = Arrangement.spacedBy(12.dp)
    )
    {
        // TODO 4: Display task titles and completion status
        // Use a simple Column or LazyColumn
        items(tasks) { task ->
            TaskColumn(
                task = task,
                navController = navController,
            )
        }
    }
}

@Composable
fun TaskRow(task: Task, navController: NavController) {

    Column(modifier = Modifier
        .clickable {
            // TODO 3: Navigate to detail screen with task title
            navController.navigate("taskDetail/${task.title}")
        }
        .padding(8.dp)
    ) {
        Text(text = task.title)
        Text(text = if (task.isCompleted) "Completed" else "Not Completed")
    }
}
