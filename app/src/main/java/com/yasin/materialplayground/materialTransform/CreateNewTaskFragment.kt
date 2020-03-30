package com.yasin.materialplayground.materialTransform

import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransform.FADE_MODE_OUT
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.fragment_create_new_task.button_create

/**
 * Created by Yasin on 30/3/20.
 */
class CreateNewTaskFragment : Fragment() {

  @RequiresApi(VERSION_CODES.M)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    sharedElementEnterTransition = MaterialContainerTransform(requireContext()).apply {
      scrimColor = resources.getColor(R.color.colorPrimary,null)
      fadeMode = FADE_MODE_OUT
      duration = 600
    }
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