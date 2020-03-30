package com.yasin.materialplayground.materialTransform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.fragment_task_created.button_done

/**
 * Created by Yasin on 30/3/20.
 */
class TaskCreatedFragment : Fragment(){

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_task_created,container,false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    button_done.setOnClickListener {
      findNavController().navigate(R.id.action_taskCreatedFragment_to_tasksFragment2)
    }
  }
}