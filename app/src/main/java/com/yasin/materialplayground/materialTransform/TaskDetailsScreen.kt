package com.yasin.materialplayground.materialTransform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialContainerTransform
import com.yasin.materialplayground.R

/**
 * Created by Yasin on 3/4/20.
 */
class TaskDetailsScreen : Fragment() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    postponeEnterTransition()
    sharedElementEnterTransition = MaterialContainerTransform(requireContext()).apply {
      scrimColor = resources.getColor(R.color.colorPrimary,null)
      fadeMode = MaterialContainerTransform.FADE_MODE_OUT
      duration = 600
    }

    sharedElementReturnTransition = MaterialContainerTransform(requireContext()).apply {
      scrimColor = resources.getColor(R.color.colorPrimary,null)
      fadeMode = MaterialContainerTransform.FADE_MODE_OUT
      duration = 600
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_details,container,false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    startPostponedEnterTransition()
  }
}