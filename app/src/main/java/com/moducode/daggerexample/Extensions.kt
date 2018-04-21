package com.moducode.daggerexample

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

inline fun FragmentManager.doTransaction(func: FragmentTransaction.() -> Unit){
    val transaction: FragmentTransaction = beginTransaction()
    transaction.func()
    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
    transaction.commit()
}

fun Int.toMegabytes(): Long {
    return this * 1024 * 1024L
}