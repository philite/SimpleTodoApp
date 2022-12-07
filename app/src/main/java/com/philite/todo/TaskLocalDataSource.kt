package com.philite.todo

import com.philite.todo.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskLocalDataSource {
    fun getTasks(): Flow<List<Task>>
    fun saveTask(task: Task)
}
