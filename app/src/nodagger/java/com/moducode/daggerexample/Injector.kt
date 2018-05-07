package com.moducode.daggerexample

import android.arch.persistence.room.Room
import com.moducode.daggerexample.room.DbRepoImpl
import com.moducode.daggerexample.room.EpisodeDB
import com.moducode.daggerexample.schedulers.SchedulersImpl
import com.moducode.daggerexample.ui.fragment.EpisodeDetailContract
import com.moducode.daggerexample.ui.fragment.EpisodeDetailFragment
import com.moducode.daggerexample.ui.fragment.EpisodeDetailPresenter


fun EpisodeDetailFragment.buildPresenter(): EpisodeDetailContract.Actions = EpisodeDetailPresenter()
        .apply {
            dbRepo = DbRepoImpl().apply {
                db = Room.databaseBuilder(this@buildPresenter.context?.applicationContext!!, EpisodeDB::class.java, "db-episodes").build()
            }
            schedulersBase = SchedulersImpl()
        }






