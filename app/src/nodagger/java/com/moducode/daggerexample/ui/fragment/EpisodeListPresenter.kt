package com.moducode.daggerexample.ui.fragment

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.moducode.daggerexample.room.DbRepo
import com.moducode.daggerexample.schedulers.SchedulersBase
import com.moducode.daggerexample.service.EpisodeService
import timber.log.Timber

class EpisodeListPresenter(private val episodeService: EpisodeService, private val schedulers: SchedulersBase, private val dbRepo: DbRepo)
    : MvpBasePresenter<EpisodeListContract.View>(), EpisodeListContract.Actions {


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