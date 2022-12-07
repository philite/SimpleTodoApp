package com.philite.todo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.philite.todo.databinding.ViewItemTaskBinding
import com.philite.todo.model.UiTask

class TaskViewHolder(
    private val binding: ViewItemTaskBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            parent: ViewGroup,
        ): TaskViewHolder {
            return TaskViewHolder(
                ViewItemTaskBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                )
            )
        }
    }

    fun fillData(uiModel: UiTask) {
        binding.taskSwitch.text = uiModel.taskName
        binding.taskSwitch.isChecked = uiModel.isDone
    }
}
