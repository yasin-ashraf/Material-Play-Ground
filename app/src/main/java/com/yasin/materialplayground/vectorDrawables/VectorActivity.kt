package com.yasin.materialplayground.vectorDrawables

import android.graphics.drawable.Animatable2
import android.graphics.drawable.Animatable2.AnimationCallback
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build.VERSION_CODES
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.activity_vector_drawable.avd
import kotlinx.android.synthetic.main.activity_vector_drawable.avd_1

/**
 * Created by Yasin on 24/3/20.
 */

class VectorActivity : AppCompatActivity() {

  private var isChecked : Boolean = false

  @RequiresApi(VERSION_CODES.M)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_vector_drawable)

    //add note 1
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


    avd_1.setOnClickListener {
      val animatable = avd_1.drawable as AnimatedVectorDrawable
      animatable.start()
      animatable.registerAnimationCallback(object : AnimationCallback() {
        override fun onAnimationEnd(drawable: Drawable?) {
          super.onAnimationEnd(drawable)
          animatable.reset()
        }
      })
    }
  }

}