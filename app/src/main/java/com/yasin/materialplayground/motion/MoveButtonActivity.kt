package com.yasin.materialplayground.motion

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.activity_move_button.button_move

/**
 * Created by Yasin on 27/3/20.
 */
class MoveButtonActivity : AppCompatActivity() {

  private var rightDX : Float = 0.0f
  private var rightDY : Float = 0.0f

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_move_button)
    button_move.setOnTouchListener(moveTouchListener)
  }

  private val moveTouchListener : View.OnTouchListener = View.OnTouchListener { view, event ->
    when(event.action) {
      MotionEvent.ACTION_DOWN -> {
        rightDX = view.x - event.rawX
        rightDY = view.y - event.rawY
      }

      MotionEvent.ACTION_MOVE -> {
        val xDisplacement = event.rawX + rightDX
        val yDisplacement = event.rawY + rightDY

        view.animate()
            .x(xDisplacement)
            .y(yDisplacement)
            .setDuration(0)
            .start()
      }
    }
    true
  }
}