package com.yasin.materialplayground.vectorDrawables

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.activity_vector_drawable.avd

/**
 * Created by Yasin on 24/3/20.
 */

class VectorActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_vector_drawable)
  }

  override fun onResume() {
    super.onResume()
    Handler().postDelayed({
      val animatable : Animatable = avd.drawable as Animatable
      animatable.start()
    },2000)
  }
}