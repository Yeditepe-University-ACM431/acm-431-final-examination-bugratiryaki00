package com.yeditepe.finalexam.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.yeditepe.finalexam.model.Task

class TaskViewModel : ViewModel() {

    // TODO 1: Create a mutable state list of Task objects
    // Initially add at least 2 tasks
    val tasks = mutableStateListOf(
        Task(id = 1, title = "Complete Final Project", isCompleted = false),
        Task(id = 2, title = "Review Code", isCompleted = true),
        Task(id = 3, title = "Say Hi to your fav teacher Engin Kandıran", isCompleted = flase)
    )

    fun toggleTask(taskId: Int) {
        // TODO 2: Update isCompleted for the given task
        val task = tasks.find { it.id == taskId }
        task?.let {
            val index = tasks.indexOf(it)
            tasks[index] = it.copy(isCompleted = !it.isCompleted)
        }
    }
}
