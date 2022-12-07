package com.philite.todo.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.philite.todo.view.TaskViewHolder
import com.philite.todo.model.UiTask

// https://guides.codepath.com/android/using-the-recyclerview
class TaskAdapter: RecyclerView.Adapter<TaskViewHolder>() {

    private val mList = mutableListOf<UiTask>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.fillData(mList[position])
    }

    override fun getItemCount(): Int = mList.size

    fun insertTasks(tasks: List<UiTask>) {
        mList.addAll(tasks)
        notifyDataSetChanged()
    }
}
