package com.moducode.daggerexample.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.moducode.daggerexample.data.EpisodeData

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM fav_episodes")
    fun getEpisodes(): List<EpisodeData>

    @Insert
    fun insertEpisode(vararg episodes: EpisodeData)

    @Delete
    fun deleteEpisode(episode: EpisodeData)

}