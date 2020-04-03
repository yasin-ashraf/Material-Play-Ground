package com.yasin.materialplayground.materialTransform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.transition.Hold
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.fragment_tasks.button_create_new_task
import kotlinx.android.synthetic.main.fragment_tasks.rv_tasks

/**
 * Created by Yasin on 30/3/20.
 */
class TasksFragment : Fragment() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    exitTransition = Hold().apply {
      duration = 600
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_tasks, container, false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    postponeEnterTransition()
    view.doOnPreDraw { startPostponedEnterTransition() }

    val taskViewClick: TaskViewClick = object : TaskViewClick {
      override fun onClick(
        view: View,
        courseId: TaskId
      ) {
        val extras = FragmentNavigatorExtras(view to "task_details")
        findNavController().navigate(R.id.action_tasksFragment_to_taskDetailsScreen,null,null,extras)
      }
    }
    rv_tasks.adapter = TasksAdapter(taskViewClick)
    val itemTouchHelper = ItemTouchHelper(ElasticItemTouchHelper())
    itemTouchHelper.attachToRecyclerView(rv_tasks)

    button_create_new_task.setOnClickListener {
      val extras = FragmentNavigatorExtras(button_create_new_task to "container_transition")
      findNavController().navigate(
          R.id.action_tasksFragment_to_createNewTaskFragment, null, null, extras
      )
    }
  }
}