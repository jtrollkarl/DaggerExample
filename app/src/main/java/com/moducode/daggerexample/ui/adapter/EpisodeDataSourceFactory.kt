package com.moducode.daggerexample.ui.adapter

import android.arch.paging.DataSource
import com.moducode.daggerexample.data.EpisodeData
import com.moducode.daggerexample.service.EpisodeService

class EpisodeDataSourceFactory(private val episodeService: EpisodeService): DataSource.Factory<Int, EpisodeData>() {

    override fun create(): DataSource<Int, EpisodeData> {
        return EpisodeDataSource(episodeService)
    }
}