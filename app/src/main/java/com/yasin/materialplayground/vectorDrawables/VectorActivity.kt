package com.yasin.materialplayground.vectorDrawables

import android.R.attr
import android.graphics.drawable.Animatable
import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.os.Handler
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.activity_vector_drawable.avd

/**
 * Created by Yasin on 24/3/20.
 */

class VectorActivity : AppCompatActivity() {

  private var isChecked : Boolean = false

  @RequiresApi(VERSION_CODES.M)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_vector_drawable)
    avd.setOnClickListener {
      val animatable = avd.drawable as AnimatedVectorDrawable
      animatable.start()
      isChecked = !isChecked
      //animator state selector not working here. no idea why?!
      animatable.registerAnimationCallback(
          @RequiresApi(VERSION_CODES.M)
          object : Animatable2.AnimationCallback() {

            override fun onAnimationEnd(drawable: Drawable?) {
              super.onAnimationEnd(drawable)

              if (isChecked) {
                val animatedVectorDrawable2 =
                  getDrawable(R.drawable.add_note_reverse) as AnimatedVectorDrawable
                avd.setImageDrawable(animatedVectorDrawable2)

              } else {

                val animatedVectorDrawable2 =
                  getDrawable(R.drawable.add_note) as AnimatedVectorDrawable
                avd.setImageDrawable(animatedVectorDrawable2)
              }

            }
          })
    }
  }

}