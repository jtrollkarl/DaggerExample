package com.moducode.daggerexample

import android.app.Application
import timber.log.Timber

open class AppAbs: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}