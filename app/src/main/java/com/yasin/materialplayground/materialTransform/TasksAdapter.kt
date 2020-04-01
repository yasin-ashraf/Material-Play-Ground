package com.yasin.materialplayground.materialTransform

import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.transition.MaterialSharedAxis
import com.yasin.materialplayground.R
import com.yasin.materialplayground.materialTransform.ElasticItemTouchHelper.ReboundableViewHolder
import com.yasin.materialplayground.viewUtils.FastOutUltraSlowIn
import kotlinx.android.synthetic.main.list_item_task.view.card
import kotlinx.android.synthetic.main.list_item_task.view.subTitle
import kotlinx.android.synthetic.main.list_item_task.view.subTitle_expanded

/**
 * Created by Yasin on 30/3/20.
 */
class TasksAdapter : ListAdapter<Task, TaskItemViewHolder>(TasksItemDiffCallback()) {

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
    holder.itemView.card.progress = 0f
    holder.itemView.setOnClickListener {
      val fadeThrough = MaterialSharedAxis.create(
          holder.itemView.context,
          MaterialSharedAxis.Y, holder.itemView.subTitle.visibility == 8)
          .apply {
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
      }
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

class TaskItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view),ReboundableViewHolder {

  override val reboundableView: View
    get() = view.card

  override fun onDrag(draggedTo: Float) {
    //item is dragged to this value
  }

  override fun onRebound(viewHolder: ReboundableViewHolder) {
    val interpolation = 1f
    viewHolder.reboundableView.card.progress = interpolation
  }
}

data class Task(
  val id: String,
  val title: String,
  val description: String
)
