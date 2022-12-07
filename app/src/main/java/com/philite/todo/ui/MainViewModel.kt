package com.philite.todo.ui

import androidx.lifecycle.*
import com.philite.todo.TaskLocalDataSource
import com.philite.todo.model.TaskToUiTaskMapper
import com.philite.todo.model.UiTask

class MainViewModel(
    private val taskLocalDataSource: TaskLocalDataSource,
) : ViewModel() {

    // https://mahendranv.github.io/posts/viewmodel-store/
    @Suppress("UNCHECKED_CAST")
    class Factory(private val taskLocalDataSource: TaskLocalDataSource): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(taskLocalDataSource) as T
        }
    }

    // https://developer.android.com/topic/libraries/architecture/coroutines#livedata
    //val tasks = liveData {
        /*
        taskDataSource.getTasks().map {
            TaskToUiTaskMapper.map(it)
        }

         */
        //emit(taskLocalDataSource.getTasks().map(TaskToUiTaskMapper::map))
    //}

    val tasks: LiveData<List<UiTask>> = taskLocalDataSource.getTasks().asLiveData().map { list ->
        list.map {
            TaskToUiTaskMapper.map(it)
        }
    }
}
