package com.philite.todo.model

object UiTaskListToTaskListMapper {
    fun map(from: List<UiTask>): List<Task> {
        return from.map {
            Task(
                taskName = it.taskName,
                isDone = it.isDone,
            )
        }
    }
}
