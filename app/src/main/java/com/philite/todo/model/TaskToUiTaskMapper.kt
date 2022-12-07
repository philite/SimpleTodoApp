package com.philite.todo.model

import com.philite.todo.model.Task
import com.philite.todo.model.UiTask

object TaskToUiTaskMapper {
    fun map(from: Task): UiTask {
        return UiTask(
            taskName = from.taskName,
            isDone = from.isDone,
        )
    }
}
