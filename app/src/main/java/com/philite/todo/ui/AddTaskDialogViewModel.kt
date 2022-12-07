package com.philite.todo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.philite.todo.TaskLocalDataSource
import com.philite.todo.model.Task


class AddTaskDialogViewModel(
    private val taskLocalDataSource: TaskLocalDataSource,
) : ViewModel() {

    @Suppress("UNCHECKED_CAST")
    class Factory(private val taskLocalDataSource: TaskLocalDataSource) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AddTaskDialogViewModel(taskLocalDataSource) as T
        }
    }

    fun addTask(taskName: String) {
        taskLocalDataSource.saveTask(
            Task(
                taskName = taskName,
                isDone = false,
            )
        )
    }
}
