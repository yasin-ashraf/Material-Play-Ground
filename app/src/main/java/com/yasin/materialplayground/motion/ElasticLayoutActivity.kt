package com.yasin.materialplayground.motion

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yasin.materialplayground.R

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
  }
}