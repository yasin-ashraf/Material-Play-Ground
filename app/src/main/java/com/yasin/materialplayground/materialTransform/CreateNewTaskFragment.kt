package com.yasin.materialplayground.materialTransform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.fragment_create_new_task.button_create

/**
 * Created by Yasin on 30/3/20.
 */
class CreateNewTaskFragment : Fragment() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_create_new_task,container,false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    button_create.setOnClickListener {
      findNavController().navigate(R.id.action_createNewTaskFragment_to_taskCreatedFragment)
    }
  }
}