package com.yasin.materialplayground.materialTransform

import android.graphics.Canvas
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlin.Float.Companion
import kotlin.math.abs
import kotlin.math.log10

/**
 * Created by Yasin on 1/4/20.
 */
class ElasticItemTouchHelper : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {

  private val elasticity: Float = 0.8f
  private val dragDismissDistancePercentage: Float = 0.2f
  private var currentItemSwiped: Boolean = false

  interface ReboundableViewHolder {
    val reboundableView : View
    fun onDrag(draggedTo: Float)
    fun onRebound(viewHolder: ReboundableViewHolder)
  }

  /**
   *set value to max, so that view is never swiped from list
   **/
  override fun getSwipeThreshold(viewHolder: ViewHolder): Float {
    return Float.MAX_VALUE
  }
  /**
   *set value to max, so that view is never swiped from list
   **/
  override fun getSwipeVelocityThreshold(defaultValue: Float): Float {
    return Companion.MAX_VALUE
  }
  /**
   *set value to max, so that view is never swiped from list
   **/
  override fun getSwipeEscapeVelocity(defaultValue: Float): Float {
    return Float.MAX_VALUE
  }

  override fun clearView(
    recyclerView: RecyclerView,
    viewHolder: ViewHolder
  ) {
    super.clearView(recyclerView, viewHolder)
    if (currentItemSwiped && viewHolder is ReboundableViewHolder){
      currentItemSwiped = false
      viewHolder.onRebound(viewHolder)
    }
  }

  override fun onMove(
    recyclerView: RecyclerView,
    viewHolder: ViewHolder,
    target: ViewHolder
  ): Boolean {
    return false
  }

  override fun onSwiped(
    viewHolder: ViewHolder,
    direction: Int
  ) {
    //after swipe is done
    //never called since swipe is never done
  }

  override fun onChildDraw(
    c: Canvas,
    recyclerView: RecyclerView,
    viewHolder: ViewHolder,
    dX: Float,
    dY: Float,
    actionState: Int,
    isCurrentlyActive: Boolean
  ) {
    val currentSwipePercentage = abs(dX) / viewHolder.itemView.width
    val dragDismissDistance = viewHolder.itemView.width * dragDismissDistancePercentage
      if(viewHolder is ReboundableViewHolder) {

      val dragFraction = log10(1 + (abs(dX) / dragDismissDistance).toDouble()).toFloat()
      val dragTo: Float = dragFraction * dragDismissDistance * elasticity
      viewHolder.reboundableView.translationX = dragTo
      viewHolder.onDrag(dragTo)

      if(currentSwipePercentage > dragDismissDistancePercentage) {
        currentItemSwiped = true
      }
    }
  }
}