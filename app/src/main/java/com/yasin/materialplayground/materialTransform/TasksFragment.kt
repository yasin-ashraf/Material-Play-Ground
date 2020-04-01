package com.yasin.materialplayground.materialTransform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.fragment_tasks.button_create_new_task
import kotlinx.android.synthetic.main.fragment_tasks.rv_tasks

/**
 * Created by Yasin on 30/3/20.
 */
class TasksFragment : Fragment() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_tasks,container,false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    rv_tasks.adapter = TasksAdapter()
    val itemTouchHelper = ItemTouchHelper(ElasticItemTouchHelper())
    itemTouchHelper.attachToRecyclerView(rv_tasks)

    button_create_new_task.setOnClickListener {
      val extras = FragmentNavigatorExtras(button_create_new_task to "container_transition")
      findNavController().navigate(R.id.action_tasksFragment_to_createNewTaskFragment, null, null, extras)
    }
  }

  private val slideCallback : ItemTouchHelper.SimpleCallback = object : ItemTouchHelper.SimpleCallback(
      0,ItemTouchHelper.RIGHT
  ) {
    override fun onMove(
      recyclerView: RecyclerView,
      viewHolder: ViewHolder,
      target: ViewHolder
    ): Boolean {
      return false
    }

    override fun onSwiped(
      viewHolder: ViewHolder,
      direction: Int
    ) {

    }
  }
}