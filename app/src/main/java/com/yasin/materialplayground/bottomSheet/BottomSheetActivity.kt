package com.yasin.materialplayground.bottomSheet

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.yasin.materialplayground.R
import com.yasin.materialplayground.normalize
import kotlinx.android.synthetic.main.activity_bottom_sheet_behaviour.arrow_left
import kotlinx.android.synthetic.main.activity_bottom_sheet_behaviour.arrow_right
import kotlinx.android.synthetic.main.activity_bottom_sheet_behaviour.background_container
import kotlinx.android.synthetic.main.activity_bottom_sheet_behaviour.bg_image

/**
 * Created by Yasin on 31/3/20.
 */
class BottomSheetActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_bottom_sheet_behaviour)

    val bottomSheetBehavior : BottomSheetBehavior<View> = BottomSheetBehavior.from(background_container)
    bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
    bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
      override fun onSlide(
        bottomSheet: View,
        slideOffset: Float
      ) {
        //offset is zero at collapsed state, 1 at expanded state
        bg_image.alpha = 1 - slideOffset
        arrow_left.rotation = slideOffset.normalize(0f,1f,-45.0f,0f)
        arrow_right.rotation = slideOffset.normalize(0f,1f,45.0f,0f)
      }

      override fun onStateChanged(
        bottomSheet: View,
        newState: Int
      ) {

      }

    })
  }
}