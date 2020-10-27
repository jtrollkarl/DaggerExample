package com.moducode.daggerexample

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import android.widget.Toast

inline fun FragmentManager.doTransaction(func: FragmentTransaction.() -> Unit){
    val transaction: FragmentTransaction = beginTransaction()
    transaction.func()
    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
    transaction.commit()
}

fun Int.toMegabytes(): Long {
    return this * 1024 * 1024L
}

fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Fragment.shortToast(msg: String?){
    Toast.makeText(this.context, msg, Toast.LENGTH_SHORT).show()
}