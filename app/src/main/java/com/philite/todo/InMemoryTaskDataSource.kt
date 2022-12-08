package com.philite.todo

import com.philite.todo.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class InMemoryTaskDataSource : TaskLocalDataSource {

    private val databaseFlow = MutableStateFlow<List<Task>>(emptyList())

    override fun getTasks(): Flow<List<Task>> {
        return databaseFlow
    }

    override fun saveTasks(tasks: List<Task>) {
        databaseFlow.value = tasks
    }
}
