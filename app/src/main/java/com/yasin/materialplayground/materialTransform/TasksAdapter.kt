package com.yasin.materialplayground.materialTransform

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yasin.materialplayground.R

/**
 * Created by Yasin on 30/3/20.
 */
class TasksAdapter : ListAdapter<Task, TaskItemViewHolder>(TasksItemDiffCallback()) {

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): TaskItemViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_task,parent,false)
    return TaskItemViewHolder(view)
  }

  override fun onBindViewHolder(
    holder: TaskItemViewHolder,
    position: Int
  ) {

  }

  override fun getItemCount(): Int {
    return 10
  }
}

class TasksItemDiffCallback : DiffUtil.ItemCallback<Task>() {
  override fun areItemsTheSame(
    oldItem: Task,
    newItem: Task
  ): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(
    oldItem: Task,
    newItem: Task
  ): Boolean {
    return oldItem != newItem
  }
}

class TaskItemViewHolder(view: View): RecyclerView.ViewHolder(view)

data class Task(
  val id: String,
  val title: String,
  val description: String
)
