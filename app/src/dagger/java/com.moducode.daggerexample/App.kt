package com.moducode.daggerexample

import android.app.Activity


class App: AppAbs(){



    companion object {
        fun get(activity: Activity): App = activity.application as App
    }


}