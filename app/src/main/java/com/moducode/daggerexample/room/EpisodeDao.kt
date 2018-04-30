package com.moducode.daggerexample.room

import android.arch.persistence.room.*
import com.moducode.daggerexample.data.EpisodeData

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM fav_episodes")
    fun getEpisodes(): List<EpisodeData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisode(vararg episodes: EpisodeData)

    @Delete
    fun deleteEpisode(episode: EpisodeData)

    @Query("SELECT * FROM fav_episodes WHERE id = :episodeId")
    fun checkEpisodeExists(episodeId: Int): List<EpisodeData>



}