package com.moducode.daggerexample

import com.moducode.daggerexample.ui.fragment.EpisodeDetailFragment
import com.moducode.daggerexample.ui.fragment.EpisodeListFragment
import com.moducode.daggerexample.ui.fragment.contract.EpisodeDetailContract
import com.moducode.daggerexample.ui.fragment.contract.EpisodeListContract
import timber.log.Timber

fun EpisodeDetailFragment.buildPresenter(): EpisodeDetailContract.Actions {
    val presenter = App.get(activity!!)
            .component
            .buildPresenterComponent()
            .buildEpisodeDetailPresenter()
    Timber.d("$presenter")
    return presenter
}


fun EpisodeListFragment.buildPresenter(): EpisodeListContract.Actions {
    val presenter = App.get(activity!!)
            .component
            .buildPresenterComponent()
            .buildEpisodeListPresenter()
    Timber.d("$presenter")
    return presenter

}



