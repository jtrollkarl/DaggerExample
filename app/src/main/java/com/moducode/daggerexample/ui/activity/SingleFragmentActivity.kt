package com.moducode.daggerexample.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.moducode.daggerexample.R
import com.moducode.daggerexample.doTransaction

abstract class SingleFragmentActivity : AppCompatActivity() {

    protected abstract val fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        setupFragment()
    }

    private fun setupFragment() {
        val savedFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (savedFragment == null) {
            val newFragment = fragment
            supportFragmentManager.doTransaction { replace(R.id.fragment_container, newFragment) }
        }
    }
}