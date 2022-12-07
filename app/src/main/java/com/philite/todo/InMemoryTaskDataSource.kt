package com.philite.todo

import com.philite.todo.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class InMemoryTaskDataSource : TaskLocalDataSource {

    private val databaseFlow = MutableStateFlow<MutableList<Task>>(mutableListOf())
    private val database = mutableListOf<Task>()

    override fun getTasks(): Flow<List<Task>> {
        return databaseFlow
    }

    override fun saveTask(task: Task) {
        database.add(task)
        databaseFlow.value = database
    }
}
