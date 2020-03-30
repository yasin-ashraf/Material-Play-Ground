package com.yasin.materialplayground.materialTransform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.Hold
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.fragment_tasks.button_create_new_task

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
    button_create_new_task.setOnClickListener {
      val extras = FragmentNavigatorExtras(button_create_new_task to "container_transition")
      findNavController().navigate(R.id.action_tasksFragment_to_createNewTaskFragment, null, null, extras)
    }
  }
}