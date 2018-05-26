package com.moducode.daggerexample

import com.moducode.daggerexample.dagger.ContextModule
import com.moducode.daggerexample.dagger.DaggerAppComponent
import com.moducode.daggerexample.ui.fragment.EpisodeDetailFragment
import com.moducode.daggerexample.ui.fragment.EpisodeListFragment
import com.moducode.daggerexample.ui.fragment.contract.EpisodeDetailContract
import com.moducode.daggerexample.ui.fragment.contract.EpisodeListContract

fun EpisodeDetailFragment.buildPresenter(): EpisodeDetailContract.Actions =
        DaggerAppComponent
                .builder()
                .contextModule(ContextModule(activity?.applicationContext!!))
                .build()
                .buildPresenterComponent()
                .buildEpisodeDetailPresenter()


fun EpisodeListFragment.buildPresenter(): EpisodeListContract.Actions =
        DaggerAppComponent
                .builder()
                .contextModule(ContextModule(activity?.applicationContext!!))
                .build()
                .buildPresenterComponent()
                .buildEpisodeListPresenter()


