package com.philite.todo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.philite.todo.InMemoryTaskDataSource
import com.philite.todo.TaskLocalDataSource
import com.philite.todo.databinding.ActivityMainBinding
import com.philite.todo.view.TaskAdapter

class MainActivity : AppCompatActivity(), AddTaskDialogFragment.OnAddTaskComplete {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel
    private val taskLocalDataSource: TaskLocalDataSource = InMemoryTaskDataSource()

    private val taskAdapter = TaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()

        // https://mahendranv.github.io/posts/viewmodel-store/
        // https://dev.to/theplebdev/android-quicky-viewmodelproviderfactory-in-kotlin-191a

        // ViewModelProvider without dependency injection
        // mViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val mainViewModelFactory = MainViewModel.Factory(taskLocalDataSource)
        mViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        observeViewModel()
    }

    private fun setUpView() {
        binding.taskRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.taskRecyclerView.adapter = taskAdapter
        binding.addFloatingActionButton.setOnClickListener {
            AddTaskDialogFragment(this).show(supportFragmentManager, null)
        }
    }

    private fun observeViewModel() {
        mViewModel.tasks.observe(this) {
            taskAdapter.insertTasks(it)
        }
    }

    override fun onAddTask(taskName: String) {
        mViewModel.addTask(taskName)
    }
}
