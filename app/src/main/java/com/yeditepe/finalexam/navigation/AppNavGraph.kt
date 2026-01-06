package com.yeditepe.finalexam.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yeditepe.finalexam.ui.TaskDetailScreen
import com.yeditepe.finalexam.ui.TaskListScreen

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "tasks"
    ) {

        // TODO 1: Add composable for "tasks"

        composable("tasks") {
            TaskListScreen(navController = navController)
        }

        // TODO 2: Add composable for "taskDetail/{title}"
        composable("taskDetail/{title}") { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            TaskDetailScreen(title = title)
        }
    }
}
