package com.moducode.daggerexample.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.moducode.daggerexample.R
import com.moducode.daggerexample.doTransaction

abstract class SingleFragmentActivity : AppCompatActivity() {

    protected abstract fun getFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        setupFragment()
    }

    private fun setupFragment() {
        val savedFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (savedFragment == null) {
            val newFragment = getFragment()
            supportFragmentManager.doTransaction { replace(R.id.fragment_container, newFragment) }
        }
    }

}