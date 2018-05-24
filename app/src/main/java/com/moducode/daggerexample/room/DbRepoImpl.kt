package com.moducode.daggerexample.room

import com.moducode.daggerexample.data.EpisodeData
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class DbRepoImpl @Inject constructor(private val db: EpisodeDB) : DbRepo {

    override fun getFavEpisodes(): Flowable<List<EpisodeData>> {
        return Flowable.fromCallable { db.episodeDao().getEpisodes() }
    }

    override fun deleteEpisode(episode: EpisodeData): Completable {
        return Completable.fromCallable { db.episodeDao().deleteEpisode(episode) }
    }

    override fun insertEpisodes(vararg episodes: EpisodeData): Completable {
        return Completable.fromCallable { db.episodeDao().insertEpisode(*episodes) }
    }

    override fun checkEpisodeExists(data: EpisodeData): Flowable<List<EpisodeData>> {
        return Flowable.fromCallable { db.episodeDao().checkEpisodeExists(data.id) }
    }
}