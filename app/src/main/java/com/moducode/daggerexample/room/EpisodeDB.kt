package com.moducode.daggerexample.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.moducode.daggerexample.data.EpisodeData

@Database(entities = [(EpisodeData::class)], version = 1, exportSchema = false)
abstract class EpisodeDB: RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
}