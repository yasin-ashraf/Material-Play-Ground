package com.yasin.materialplayground.motion

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.yasin.materialplayground.R
import com.yasin.materialplayground.viewUtils.ElasticFrameLayout.ElasticDragCallback
import kotlinx.android.synthetic.main.activity_elastic.elastic
import kotlinx.android.synthetic.main.activity_elastic.progressBar

/**
 * Created by Yasin on 28/3/20.
 */
class ElasticLayoutActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_elastic)
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

    elastic.setListener(object : ElasticDragCallback {
      override fun onDrag(
        dragDismissDistance: Float,
        draggedDistance: Float) {
        progressBar.translationY = draggedDistance
      }

      override fun onDragDismiss() {
        progressBar.animate().translationY(0f).start()
        elastic.animate()
            .translationY(0f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(200L)
            .setInterpolator(FastOutSlowInInterpolator())
            .start()
      }
    })
  }
}