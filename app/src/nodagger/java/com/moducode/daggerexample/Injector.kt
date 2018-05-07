package com.moducode.daggerexample

import com.moducode.daggerexample.room.DbRepoImpl
import com.moducode.daggerexample.schedulers.SchedulersImpl
import com.moducode.daggerexample.ui.fragment.EpisodeDetailContract
import com.moducode.daggerexample.ui.fragment.EpisodeDetailFragment
import com.moducode.daggerexample.ui.fragment.EpisodeDetailPresenter


fun EpisodeDetailFragment.buildPresenter(): EpisodeDetailContract.Actions = EpisodeDetailPresenter()
        .apply {
            dbRepo = DbRepoImpl(activity?.applicationContext!!)
            schedulersBase = SchedulersImpl()
        }

