package com.moducode.daggerexample.schedulers

import io.reactivex.Scheduler

interface SchedulersBase {

    fun io(): Scheduler

    fun ui(): Scheduler

    fun compute(): Scheduler

}