package com.moducode.daggerexample

import android.arch.persistence.room.Room
import com.moducode.daggerexample.room.DbRepoImpl
import com.moducode.daggerexample.room.EpisodeDB
import com.moducode.daggerexample.schedulers.SchedulersImpl
import com.moducode.daggerexample.service.EpisodeService
import com.moducode.daggerexample.service.RetrofitFactory
import com.moducode.daggerexample.ui.fragment.*


fun EpisodeDetailFragment.buildPresenter(): EpisodeDetailContract.Actions = EpisodeDetailPresenter()
        .apply {
            dbRepo = DbRepoImpl().apply {
                db = Room.databaseBuilder(this@buildPresenter.context?.applicationContext!!, EpisodeDB::class.java, "db-episodes").build()
            }
            schedulersBase = SchedulersImpl()
        }

fun EpisodeListFragment.buildPresenter(): EpisodeListContract.Actions = EpisodeListPresenter()
        .apply {
            episodeService = RetrofitFactory.create(this@buildPresenter.context?.cacheDir!!, EpisodeService::class.java)
            schedulers = SchedulersImpl()
            dbRepo = DbRepoImpl().apply {
                db = Room.databaseBuilder(this@buildPresenter.context?.applicationContext!!, EpisodeDB::class.java, "db-episodes").build()
            }
        }





