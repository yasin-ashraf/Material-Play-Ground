package com.yasin.materialplayground.shrinkingButton

import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import com.yasin.materialplayground.R
import kotlinx.android.synthetic.main.activity_shrink_button.*


class ShrinkButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shrink_button)
        shrink_button.setOnClickListener {
            shrinkButton()
            Handler().postDelayed({
                progress_circular.visibility = View.VISIBLE
                shrink_me.visibility = View.INVISIBLE
            },300)
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
//            it.doOnEnd {
//                progress_circular.visibility = View.VISIBLE
//                shrink_me.visibility = View.INVISIBLE
//            }
            it.start()
        }
    }
}