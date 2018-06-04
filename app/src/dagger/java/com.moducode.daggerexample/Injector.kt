package com.moducode.daggerexample


import com.moducode.daggerexample.ui.fragment.EpisodeDetailFragment
import com.moducode.daggerexample.ui.fragment.EpisodeListFragment
import com.moducode.daggerexample.ui.fragment.contract.EpisodeDetailContract
import com.moducode.daggerexample.ui.fragment.contract.EpisodeListContract

fun EpisodeDetailFragment.buildPresenter(): EpisodeDetailContract.Actions =
        App.get(activity!!)
                .component
                .buildEpisodeDetailPresenter()

fun EpisodeListFragment.buildPresenter(): EpisodeListContract.Actions =
        App.get(activity!!)
                .component
                .buildPresenterComponent()
                .buildEpisodeListPresenter()




