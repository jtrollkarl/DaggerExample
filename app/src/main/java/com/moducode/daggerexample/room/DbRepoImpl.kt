package com.moducode.daggerexample.room

import android.arch.persistence.room.Room
import android.content.Context
import com.moducode.daggerexample.data.EpisodeData
import io.reactivex.Completable
import io.reactivex.Flowable

class DbRepoImpl(context: Context) : DbRepo {

    private val db = Room.databaseBuilder(context, EpisodeDB::class.java, "db-episodes").build()

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
        return Flowable.fromCallable {db.episodeDao().checkEpisodeExists(data.id)}
    }
}