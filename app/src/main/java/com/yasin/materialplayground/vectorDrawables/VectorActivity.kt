package com.yasin.materialplayground.vectorDrawables

import android.R.attr
import android.graphics.drawable.Animatable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.activity_vector_drawable.avd

/**
 * Created by Yasin on 24/3/20.
 */

class VectorActivity : AppCompatActivity() {

  private var isChecked : Boolean = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_vector_drawable)
    avd.setOnClickListener {
      isChecked = !isChecked
      val stateSet = intArrayOf(attr.state_checked * if (isChecked) 1 else -1)
      avd.setImageState(stateSet,true)
//      val animatable = avd.drawable as Animatable
//      animatable.start()
    }
  }

}