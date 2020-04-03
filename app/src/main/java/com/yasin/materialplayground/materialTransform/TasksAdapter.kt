package com.yasin.materialplayground.materialTransform

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yasin.materialplayground.R
import com.yasin.materialplayground.materialTransform.ElasticItemTouchHelper.ReboundableViewHolder
import com.yasin.materialplayground.normalize
import kotlinx.android.synthetic.main.list_item_task.view.card

/**
 * Created by Yasin on 30/3/20.
 */
class TasksAdapter(private val taskViewClick: TaskViewClick) : ListAdapter<Task, TaskItemViewHolder>(TasksItemDiffCallback()) {

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): TaskItemViewHolder {
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.list_item_task, parent, false)
    return TaskItemViewHolder(view)
  }

  override fun onBindViewHolder(
    holder: TaskItemViewHolder,
    position: Int
  ) {
    holder.itemView.transitionName = "task_details$position"
    holder.itemView.card.progress = if (holder.itemView.isActivated) 1f else 0f
    holder.itemView.setOnClickListener {
      taskViewClick.onClick(it,"task_details$position")
      //material axis animation
      /*val fadeThrough = MaterialSharedAxis.create(
          holder.itemView.context,
          MaterialSharedAxis.Y, holder.itemView.subTitle.visibility == 8
      ).apply {
            duration = 600
            interpolator = FastOutUltraSlowIn()
          }
      TransitionManager.beginDelayedTransition(holder.itemView as ViewGroup, fadeThrough)
      if (holder.itemView.subTitle.visibility == View.VISIBLE) {
        holder.itemView.subTitle.visibility = View.GONE
        holder.itemView.subTitle_expanded.visibility = View.VISIBLE
      } else {
        holder.itemView.subTitle_expanded.visibility = View.GONE
        holder.itemView.subTitle.visibility = View.VISIBLE
      }*/
    }
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

class TaskItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view),
    ReboundableViewHolder {

  override val reboundableView: View
    get() = view.card

  override fun onDrag(draggedTo: Float) {
    Log.d("Dragged To", "dragged to = $draggedTo")
    val interpolation = draggedTo.normalize(0f, 120f, 0f, 1f)// need better computation
    Log.d("Dragged To", "interpolation = $interpolation")
    this.reboundableView.card.progress = interpolation
  }

  override fun onRebound(viewHolder: ReboundableViewHolder) {
    viewHolder.reboundableView.isActivated = true

  }
}

interface TaskViewClick {
  fun onClick(view: View, courseId: TaskId)
}

typealias TaskId = String

data class Task(
  val id: String,
  val title: String,
  val description: String,
  val isSelected: Boolean
)
