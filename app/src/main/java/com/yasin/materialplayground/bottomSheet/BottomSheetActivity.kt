package com.yasin.materialplayground.bottomSheet

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.yasin.materialplayground.R
import com.yasin.materialplayground.normalize
import kotlinx.android.synthetic.main.activity_bottom_sheet_behaviour.arrow_left
import kotlinx.android.synthetic.main.activity_bottom_sheet_behaviour.arrow_right
import kotlinx.android.synthetic.main.activity_bottom_sheet_behaviour.background_container
import kotlinx.android.synthetic.main.activity_bottom_sheet_behaviour.bg_image
import kotlinx.android.synthetic.main.activity_bottom_sheet_behaviour.foreground_container
import kotlin.LazyThreadSafetyMode.NONE

/**
 * Created by Yasin on 31/3/20.
 */
class BottomSheetActivity : AppCompatActivity() {

  private val sheetBgDrawable : MaterialShapeDrawable by lazy(NONE) {
    val bgContext = background_container.context
    MaterialShapeDrawable(
        bgContext,
        null,
        R.attr.bottomSheetStyle,
        0
    ).apply {
      fillColor = ColorStateList.valueOf(bgContext.getColor(R.color.terractoca_brick_dark))
      elevation = resources.getDimension(R.dimen.plane_32)
      setShadowColor(bgContext.getColor(R.color.terractoca_brick_dark))
      shadowCompatibilityMode = MaterialShapeDrawable.SHADOW_COMPAT_MODE_ALWAYS
      shapeAppearanceModel = ShapeAppearanceModel().toBuilder()
          .setTopLeftCorner(CornerFamily.ROUNDED,resources.getDimension(R.dimen.plane_16))
          .setTopRightCorner(CornerFamily.ROUNDED,resources.getDimension(R.dimen.plane_16))
          .build()
    }
  }

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
        sheetBgDrawable.interpolation = 1 - slideOffset
      }

      override fun onStateChanged(
        bottomSheet: View,
        newState: Int
      ) {

      }
    })

    foreground_container.background = sheetBgDrawable
  }
}