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
