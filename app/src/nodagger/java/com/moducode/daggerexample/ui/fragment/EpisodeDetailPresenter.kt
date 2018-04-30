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
        dbRepo.checkEpisodeExists(episodeData)
                .subscribeOn(schedulersBase.io())
                .observeOn(schedulersBase.ui())
                .flatMap { list ->
                    if (list.isEmpty()) {
                        Timber.d("Episode ${episodeData.number} did not exist. Inserting...")
                        return@flatMap dbRepo.insertEpisodes(episodeData).toFlowable<Unit>().subscribeOn(schedulersBase.io()).observeOn(schedulersBase.ui())
                    }else{
                        Timber.d("Episode ${episodeData.number} existed. Deleting...")
                        return@flatMap dbRepo.deleteEpisode(episodeData).toFlowable<Unit>().subscribeOn(schedulersBase.io()).observeOn(schedulersBase.ui())
                    }
                }.subscribe(
                        { Timber.d("Insert/delete onNext")},
                        { e -> Timber.e(e) },
                        { Timber.d("Insert/delete complete") }
                )


    }

}