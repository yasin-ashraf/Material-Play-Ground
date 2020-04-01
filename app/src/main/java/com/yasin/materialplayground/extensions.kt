package com.yasin.materialplayground

import android.content.res.Resources
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()

fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction()
            .func()
            .commit()
}

inline fun FragmentManager.inAddToBackStackTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction()
            .addToBackStack(null)
            .func()
            .commit()
}

/**
 * Coerce the receiving Float between inputMin and inputMax and linearly interpolate to the
 * outputMin to outputMax scale. This function is able to handle ranges which span negative and
 * positive numbers.
 *
 * This differs from [lerp] as the input values are not required to be between 0 and 1.
 */
fun Float.normalize(
    inputMin: Float,
    inputMax: Float,
    outputMin: Float,
    outputMax: Float
): Float {
    if (this < inputMin) {
        return outputMin
    } else if (this > inputMax) {
        return outputMax
    }

    return outputMin * (1 - (this - inputMin) / (inputMax - inputMin)) +
        outputMax * ((this - inputMin) / (inputMax - inputMin))
}
