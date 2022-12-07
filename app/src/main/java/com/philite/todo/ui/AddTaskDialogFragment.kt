package com.philite.todo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.philite.todo.TaskLocalDataSource
import com.philite.todo.databinding.FragmentDialogAddTaskBinding

class AddTaskDialogFragment(
    private val taskLocalDataSource: TaskLocalDataSource
): DialogFragment() {

    // https://kotlinlang.org/docs/properties.html#backing-properties
    private lateinit var _binding: FragmentDialogAddTaskBinding
    private lateinit var mViewModel: AddTaskDialogViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDialogAddTaskBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addTaskDialogViewModelFactory = AddTaskDialogViewModel.Factory(taskLocalDataSource)
        mViewModel = ViewModelProvider(this, addTaskDialogViewModelFactory)[AddTaskDialogViewModel::class.java]

        setUpView()
    }

    private fun setUpView() {
        // fixme: Validate
        _binding.addTaskButton.setOnClickListener {
            mViewModel.addTask(_binding.addTaskTextInputEditText.text.toString())
            dismiss()
        }
    }

}
