package com.moducode.daggerexample.ui.fragment

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.moducode.daggerexample.room.DbRepo
import com.moducode.daggerexample.schedulers.SchedulersBase
import com.moducode.daggerexample.service.EpisodeService
import timber.log.Timber
import javax.inject.Inject

class EpisodeListPresenter : MvpBasePresenter<EpisodeListContract.View>(), EpisodeListContract.Actions {

    @Inject lateinit var episodeService: EpisodeService
    @Inject lateinit var schedulers: SchedulersBase
    @Inject lateinit var dbRepo: DbRepo


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

    override fun fetchFavourites() {
        dbRepo.getFavEpisodes()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribe(
                        { next -> ifViewAttached { it.setData(next) } },
                        { e ->
                            Timber.e(e)
                            ifViewAttached { it.showError(e) }
                        },
                        { Timber.d("favourites fetch complete") }
                )
    }
}