package com.example.todo.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable fun AddTaskScreen(viewModel: AddTaskScreenViewModel=viewModel())
{
Column (
    modifier = Modifier
        .padding(24.dp)
        .fillMaxSize()
){
val title=viewModel.taskTitle.value
    val description=viewModel.taskDescription.value
    val duedate=viewModel.dueDate.value
    TextField(onValueChange = {viewModel.taskTitleChange(it)},
        value = title,
        label = { Text("enter task title") })

    TextField(value =duedate ,
        onValueChange = {viewModel.dueDateChange(it)},
        label = { Text("Due Date") }
        )
    TextField(
        value = description,
        onValueChange = { viewModel.taskDescriptionChange(it) },
        label = { Text("Enter Task Description") }
    )

    Button(onClick = {
        viewModel.onSaveClick()
    }) {
            Text(text = viewModel.saveresult.value)
    }
}
}