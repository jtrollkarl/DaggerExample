package com.moducode.daggerexample.ui.fragment

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.moducode.daggerexample.data.EpisodeData
import com.moducode.daggerexample.room.DbRepo
import com.moducode.daggerexample.schedulers.SchedulersBase
import timber.log.Timber

class EpisodeDetailPresenter(private val dbRepo: DbRepo, private val schedulersBase: SchedulersBase) :
        MvpBasePresenter<EpisodeDetailContract.View>(),
        EpisodeDetailContract.Actions {


    override fun saveEpisode(episodeData: EpisodeData) {
        dbRepo.insertEpisodes(episodeData)
                .subscribeOn(schedulersBase.io())
                .observeOn(schedulersBase.ui())
                .subscribe(
                        { Timber.d("insert for ${episodeData.id} complete") },
                        { Timber.e(it.message) }
                )
    }

    override fun deleteEpisode(episodeData: EpisodeData) {
        dbRepo.deleteEpisode(episodeData)
                .subscribeOn(schedulersBase.io())
                .observeOn(schedulersBase.ui())
                .subscribe(
                        { Timber.d("delete for ${episodeData.id} complete") },
                        { Timber.e(it.message) }
                )
    }

}