package com.philite.todo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.philite.todo.databinding.FragmentDialogAddTaskBinding

class AddTaskDialogFragment(
    private val onAddTaskCompleteListener: OnAddTaskComplete,
): DialogFragment() {

    // https://kotlinlang.org/docs/properties.html#backing-properties
    private lateinit var binding: FragmentDialogAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDialogAddTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
    }

    private fun setUpView() {
        // fixme: Validate
        binding.addTaskButton.setOnClickListener {
            onAddTaskCompleteListener.onAddTask(binding.addTaskTextInputEditText.text.toString())
            dismiss()
        }
    }

    interface OnAddTaskComplete {
        fun onAddTask(taskName: String)
    }
}
