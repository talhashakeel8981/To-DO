package com.example.todo.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items

@Composable
fun TaskListScreen(viewModel: AddTaskScreenViewModel = viewModel()) {
    val taskList = viewModel.tasks

    LazyColumn {
        items(taskList) { task ->
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Title: ${task.title}")
                Text(text = "Description: ${task.description}")
                Text(text = "Due Date: ${task.dueDate}")
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}
