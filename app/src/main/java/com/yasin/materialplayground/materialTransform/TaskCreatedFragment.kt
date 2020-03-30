package com.yasin.materialplayground.materialTransform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.Scale
import com.yasin.materialplayground.R
import com.yasin.materialplayground.viewUtils.FastOutUltraSlowIn
import kotlinx.android.synthetic.main.fragment_task_created.button_done

/**
 * Created by Yasin on 30/3/20.
 */
class TaskCreatedFragment : Fragment(){

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    //MaterialAxis Transition
    enterTransition = Scale().apply {
      incomingStartScale = 0f
      outgoingEndScale = 1f
      duration = 800
      interpolator = FastOutUltraSlowIn()
    }
    returnTransition = Scale().apply {
      outgoingStartScale = 1f
      outgoingEndScale = 0f
      duration = 400
      interpolator = FastOutUltraSlowIn()
    }
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
      findNavController().navigateUp()
    }
  }
}