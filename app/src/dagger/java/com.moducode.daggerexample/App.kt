package com.moducode.daggerexample

import android.app.Activity
import com.moducode.daggerexample.dagger.AppComponent
import com.moducode.daggerexample.dagger.ContextModule
import com.moducode.daggerexample.dagger.DaggerAppComponent


class App : AppAbs() {

    lateinit var component: AppComponent

    companion object {
        fun get(activity: Activity): App = activity.application as App
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
                .builder()
                .contextModule(ContextModule(this))
                .build()
    }

}
