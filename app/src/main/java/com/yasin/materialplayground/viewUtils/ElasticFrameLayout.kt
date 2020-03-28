package com.yasin.materialplayground.viewUtils

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.yasin.materialplayground.R

/**
 * Created by Yasin on 28/3/20.
 */
class ElasticFrameLayout  : FrameLayout {

  //variable properties
  private var shouldContentScale : Boolean = false
  private var scaleFactor : Float = 1.0f
  private var elasticity : Float = 1.0f
  private var dragDismissDistance : Int = Int.MAX_VALUE

  //other properties
  private var isDraggingDown : Boolean = false
  private var isDraggingUp : Boolean = false

  constructor(context: Context) : super(context,null,0,0)

  constructor(context: Context, attributeSet: AttributeSet) : super(context,attributeSet,0,0)

  constructor(context: Context, attributeSet: AttributeSet, @AttrRes defStyleAttr : Int) : super(context,attributeSet,defStyleAttr,0)

  constructor(context: Context, attributeSet: AttributeSet, @AttrRes defStyleAttr: Int,@StyleRes defStyleRes : Int ) : super(context,attributeSet,defStyleAttr,defStyleRes) {
    val a : TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ElasticFrameLayout, defStyleAttr, defStyleRes)
    shouldContentScale = a.getBoolean(R.styleable.ElasticFrameLayout_shouldContentScale,false)
    scaleFactor = a.getFloat(R.styleable.ElasticFrameLayout_scaleFactor_value,1.0f)
    elasticity = a.getFloat(R.styleable.ElasticFrameLayout_elasticity_value,1.0f)
    dragDismissDistance = a.getDimensionPixelSize(R.styleable.ElasticFrameLayout_drag_dismiss_distance,0)
    a.recycle()
  }

  /**
   * Should return true here when the child view is scrolled vertically to get the scrolling
   * callbacks in parent view (this view)
   * onNestedPrescroll and then onNestedScroll is called when scrolled
   **/
  override fun onStartNestedScroll(
    child: View?,
    target: View?,
    nestedScrollAxes: Int
  ): Boolean {
    return nestedScrollAxes == View.SCROLL_AXIS_VERTICAL
  }

  override fun onNestedPreScroll(
    target: View?,
    dx: Int,
    dy: Int,
    consumed: IntArray?
  ) {
    if(dy > 0 && isDraggingDown || dy < 0 && isDraggingUp) {
      //dy - scroll distance
      translateView(dy)
    }
  }

  override fun onNestedScroll(
    target: View?,
    dxConsumed: Int,
    dyConsumed: Int,
    dxUnconsumed: Int,
    dyUnconsumed: Int
  ) {
    //dyUnconsumed is the scroll distance unconsumed by the child view - which is the scroll distance
    translateView(dyUnconsumed)
  }

  override fun onStopNestedScroll(child: View?) {
    // dismiss scroll : move view back to original position

  }

  private fun translateView(scrollAmount: Int) {
    if(scrollAmount == 0) return

  }
}