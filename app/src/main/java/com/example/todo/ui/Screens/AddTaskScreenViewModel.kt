package com.example.todo.ui.Screens

import android.app.ActivityManager.TaskDescription
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf


class AddTaskScreenViewModel:ViewModel() {

    private val _taskTitle = mutableStateOf("")
    private val _taskDescription = mutableStateOf("")
    private val _dueDate = mutableStateOf("")
    private val _saveresult = mutableStateOf("")

    private val _tasks= mutableStateListOf<Task>()
    val tasks:List <Task> = _tasks

    val taskTitle: State<String> = _taskTitle
    val taskDescription: State<String> = _taskDescription
    val dueDate: State<String> = _dueDate
    val saveresult: State<String> = _saveresult

    fun taskTitleChange(newTaskTitle: String) {
        _taskTitle.value = newTaskTitle
    }


    fun taskDescriptionChange(newtaskDescription: String) {
        _taskDescription.value = newtaskDescription
    }

    fun dueDateChange(newDueDate: String) {
        _dueDate.value = newDueDate
    }

    fun onSaveClick() {
        val title = _taskTitle.value
        val description = _taskDescription.value
        val dueDate = _dueDate.value

        if (title.isBlank() || description.isBlank() || dueDate.isBlank()) {
            _saveresult.value = "Please fill all the fields"
            return
        }

        val task = Task(title, description, dueDate)
        _tasks.add(task) // ✅ Add task
        _saveresult.value = "Task saved!"

        println("Current Tasks: $_tasks") // ✅ This will now work

        // Optionally clear fields
        _taskTitle.value = ""
        _taskDescription.value = ""
        _dueDate.value = ""
    }
//initialsssxxxssss

}