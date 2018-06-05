package com.moducode.daggerexample

import android.arch.persistence.room.Room
import com.moducode.daggerexample.room.DbRepoImpl
import com.moducode.daggerexample.room.EpisodeDB
import com.moducode.daggerexample.schedulers.SchedulersImpl
import com.moducode.daggerexample.service.EpisodeService
import com.moducode.daggerexample.service.RetrofitFactory
import com.moducode.daggerexample.ui.fragment.*
import com.moducode.daggerexample.ui.fragment.contract.EpisodeDetailContract
import com.moducode.daggerexample.ui.fragment.contract.EpisodeListContract


fun EpisodeDetailFragment.buildPresenter(): EpisodeDetailContract.Actions =
        EpisodeDetailPresenter(
                DbRepoImpl(Room.databaseBuilder(this@buildPresenter.context?.applicationContext!!, EpisodeDB::class.java, "db-episodes").build()),
                SchedulersImpl())


fun EpisodeListFragment.buildPresenter(): EpisodeListContract.Actions =
        EpisodeListPresenter(RetrofitFactory.create(this@buildPresenter.context?.cacheDir!!, EpisodeService::class.java),
                SchedulersImpl(),
                DbRepoImpl(Room.databaseBuilder(this@buildPresenter.context?.applicationContext!!, EpisodeDB::class.java, "db-episodes").build()))






