package com.moducode.daggerexample

import com.moducode.daggerexample.dagger.ContextModule
import com.moducode.daggerexample.dagger.DaggerPresenterComponent
import com.moducode.daggerexample.ui.fragment.EpisodeDetailFragment
import com.moducode.daggerexample.ui.fragment.EpisodeDetailPresenter
import com.moducode.daggerexample.ui.fragment.EpisodeListFragment
import com.moducode.daggerexample.ui.fragment.EpisodeListPresenter
import com.moducode.daggerexample.ui.fragment.contract.EpisodeDetailContract
import com.moducode.daggerexample.ui.fragment.contract.EpisodeListContract

fun EpisodeDetailFragment.buildPresenter(): EpisodeDetailContract.Actions{
    val component = DaggerPresenterComponent.builder().contextModule(ContextModule(this.context!!)).build()
    val presenter = EpisodeDetailPresenter()
    component.injectEpisodeDetailPresenter(presenter)
    return presenter
}

fun EpisodeListFragment.buildPresenter(): EpisodeListContract.Actions =
        DaggerPresenterComponent.builder().contextModule(ContextModule(this.context!!)).build().let {
            val presenter = EpisodeListPresenter()
            it.injectEpisodeListPresenter(presenter)
            presenter
        }