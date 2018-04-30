package com.moducode.daggerexample.room

import com.moducode.daggerexample.data.EpisodeData
import io.reactivex.Completable
import io.reactivex.Flowable

interface DbRepo {

    fun getFavEpisodes(): Flowable<List<EpisodeData>>

    fun deleteEpisode(episode: EpisodeData): Completable

    fun insertEpisodes(vararg episodes: EpisodeData): Completable

    fun checkEpisodeExists(data: EpisodeData): Flowable<List<EpisodeData>>

}