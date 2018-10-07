package com.moducode.daggerexample.ui.fragment

import android.annotation.SuppressLint
import android.arch.paging.PagedList
import android.arch.paging.RxPagedListBuilder
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.moducode.daggerexample.data.EpisodeData
import com.moducode.daggerexample.room.DbRepo
import com.moducode.daggerexample.schedulers.SchedulersBase
import com.moducode.daggerexample.service.EpisodeService
import com.moducode.daggerexample.ui.adapter.EpisodeDataSource
import com.moducode.daggerexample.ui.adapter.EpisodeDataSourceFactory
import com.moducode.daggerexample.ui.fragment.contract.EpisodeListContract
import timber.log.Timber
import javax.inject.Inject

class EpisodeListPresenter @Inject constructor(private val episodeService: EpisodeService,
                                               private val schedulers: SchedulersBase,
                                               private val dbRepo: DbRepo)
    : MvpBasePresenter<EpisodeListContract.View>(), EpisodeListContract.Actions {

    private val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(1)
            .setInitialLoadSizeHint(2)
            .build()

    @SuppressLint("CheckResult")
    override fun fetchEpisodes() {
/*        episodeService.getSouthParkEps()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribe({ result -> ifViewAttached { it.setData(result) } },
                        { error ->
                            ifViewAttached {
                                it.showError(error)
                                Timber.e(error)
                            }
                        }
                )*/

        RxPagedListBuilder<Int, EpisodeData>(EpisodeDataSourceFactory(episodeService), config)
                .buildObservable()
                .subscribe { result -> ifViewAttached { it.setData(result) }}
    }

    @SuppressLint("CheckResult")
    override fun fetchFavourites() {
/*        dbRepo.getFavEpisodes()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribe(
                        { next -> ifViewAttached { it.setData(next) } },
                        { e ->
                            Timber.e(e)
                            ifViewAttached { it.showError(e) }
                        },
                        { Timber.d("favourites fetch complete") }
                )*/
    }
}