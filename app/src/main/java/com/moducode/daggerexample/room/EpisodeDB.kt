package com.moducode.daggerexample.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.moducode.daggerexample.data.EpisodeData

@Database(entities = [(EpisodeData::class)], version = 1, exportSchema = false)
abstract class EpisodeDB: RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
}