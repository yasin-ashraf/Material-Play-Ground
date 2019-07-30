package com.yasin.materialplayground.shrinkingButton

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewAnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.activity_shrink_button.*
import kotlin.math.max


class ShrinkButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shrink_button)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        shrink_button.setOnClickListener {
            shrinkButton()
            showProgressBar()
        }
    }

    private fun shrinkButton() {
        val valueAnimator : ValueAnimator = ValueAnimator.ofInt(shrink_button.width,1)
        valueAnimator.apply {
            addUpdateListener {
                val value : Int = it.animatedValue as Int
                val layoutParams = shrink_button.layoutParams
                layoutParams.width = value
                shrink_button.requestLayout()
            }
        }.also {
            it.duration = 500
            it.start()
        }
    }

    private fun showProgressBar() {
        shrink_me.animate()
                .alpha(1f)
                .setDuration(300)
                .setListener(object : AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        progress_circular.visibility = View.VISIBLE
                        Handler().postDelayed(({
                            reveal()
                        }),2000)
                    }
                })
    }

    private fun reveal() {
        val viewWidth = view.width
        val viewHeight = view.height
        val finalRadius = max(viewWidth, viewHeight) * 1.2f // to over-bound the view

        val startX = (progress_circular.x + ( progress_circular.width / 2 )).toInt()
        val startY = (progress_circular.y + ( progress_circular.width / 2 )).toInt()
        val reveal = ViewAnimationUtils
                .createCircularReveal(view, startX, startY, progress_circular.width * 1f, finalRadius)

        reveal.duration = 2000
        view.visibility = View.VISIBLE
        reveal.start()
    }
}