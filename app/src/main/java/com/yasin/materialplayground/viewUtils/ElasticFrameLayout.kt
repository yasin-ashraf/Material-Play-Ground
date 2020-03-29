package com.yasin.materialplayground.viewUtils

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.yasin.materialplayground.R
import kotlin.math.abs
import kotlin.math.log10

/**
 * Created by Yasin on 28/3/20.
 */
class ElasticFrameLayout @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet?,
  @AttrRes defStyleAttr: Int = 0,
  @StyleRes defStyleRes : Int = 0
) : FrameLayout(context,attributeSet,defStyleAttr,defStyleRes) {

  //variable properties
  private var shouldContentScale : Boolean = false
  private var scaleFactor : Float = 1.0f
  private var elasticity : Float = 1.0f
  private var dragDismissDistance : Int = Int.MAX_VALUE

  //other properties
  private var isDraggingDown : Boolean = false
  private var isDraggingUp : Boolean = false
  private var totalDrag : Float = 0.0f

  init {
    val a : TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ElasticFrameLayout, defStyleAttr,defStyleRes)
    shouldContentScale = a.getBoolean(R.styleable.ElasticFrameLayout_shouldContentScale,false)
    scaleFactor = a.getFloat(R.styleable.ElasticFrameLayout_scaleFactor_value,1.0f)
    elasticity = a.getFloat(R.styleable.ElasticFrameLayout_elasticity_value,1.0f)
    dragDismissDistance = a.getDimensionPixelSize(R.styleable.ElasticFrameLayout_drag_dismiss_distance,0)
    a.recycle()
  }

  /**
   * Should return true here when the child view is scrolled vertically to get the scrolling
   * callbacks in parent view (this view)
   * onNestedPreScroll and then onNestedScroll is called when scrolled
   **/
  override fun onStartNestedScroll(
    child: View?,
    target: View?,
    nestedScrollAxes: Int
  ): Boolean {
    return (nestedScrollAxes and View.SCROLL_AXIS_VERTICAL) != 0
  }

  override fun onNestedScroll(
    target: View?,
    dxConsumed: Int,
    dyConsumed: Int,
    dxUnconsumed: Int,
    dyUnconsumed: Int
  ) {
    //dyUnconsumed is the touch events unconsumed by Scrollable content, i.e if the content cannot scroll further
    //dyUnconsumed is non zero. +ve when scroll down and -ve when scroll up
    translateView(dyUnconsumed)
  }

  override fun onStopNestedScroll(child: View?) {
    // dismiss scroll : move view back to original position
    animate()
        .translationY(0f)
        .scaleX(1f)
        .scaleY(1f)
        .setDuration(200L)
        .setInterpolator(FastOutSlowInInterpolator())
        .setListener(null)
        .start()
    totalDrag = 0.0f
    isDraggingUp = false
    isDraggingDown = false
  }

  private fun translateView(scrollAmount: Int) {
    if(scrollAmount == 0) return

    totalDrag += scrollAmount.toFloat()

    if (scrollAmount < 0 && !isDraggingUp && !isDraggingDown) {
      isDraggingDown = true
    } else if (scrollAmount > 0 && !isDraggingDown && !isDraggingUp) {
      isDraggingUp = true
    }

    // how far have we dragged relative to the distance to perform a dismiss
    // (0–1 where 1 = dismiss distance). Decreasing logarithmically as we approach the limit
    var dragFraction = log10(1 + (abs(totalDrag) / dragDismissDistance).toDouble()).toFloat()

    // calculate the desired translation given the drag fraction
    var dragTo: Float = dragFraction * dragDismissDistance * elasticity

    //if dragging up move translation in opposite direction
    if (isDraggingUp) dragTo *= -1f
    //apply translation
    translationY = dragTo
    //apply scale
    if (shouldContentScale) {
      val scale = 1 - (1 - scaleFactor) * dragFraction
      scaleX = scale
      scaleY = scale
    }

    // if we've reversed direction and gone past the settle point then clear the flags to
    // allow the list to get the scroll events & reset any transforms
    if ((isDraggingDown && totalDrag >= 0)
        || (isDraggingUp && totalDrag <= 0)) {
      dragFraction = 0f
      dragTo = dragFraction
      totalDrag = dragTo
      isDraggingUp = false
      isDraggingDown = isDraggingUp
      translationY = 0f
      scaleX = 1f
      scaleY = 1f
    }
  }
}