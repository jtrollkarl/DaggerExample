package com.moducode.daggerexample.ui.fragment

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.moducode.daggerexample.schedulers.SchedulersBase
import com.moducode.daggerexample.service.EpisodeService
import timber.log.Timber

class EpisodeListPresenter(val episodeService: EpisodeService, val schedulers: SchedulersBase) : MvpBasePresenter<EpisodeListContract.View>(),
        EpisodeListContract.Actions {


    override fun fetchEpisodes() {
        episodeService.getSouthParkEps()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribe({ result -> ifViewAttached { it.setData(result) } },
                        { error ->
                            ifViewAttached {
                                it.showError(error)
                                Timber.e(error)
                            }
                        }
                )
    }


}