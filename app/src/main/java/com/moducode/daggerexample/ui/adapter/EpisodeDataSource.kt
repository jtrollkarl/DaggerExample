package com.moducode.daggerexample.ui.adapter

import android.annotation.SuppressLint
import android.arch.paging.ItemKeyedDataSource
import com.moducode.daggerexample.data.EpisodeData
import com.moducode.daggerexample.service.EpisodeService

class EpisodeDataSource(private val service: EpisodeService): ItemKeyedDataSource<Int, EpisodeData>() {

    @SuppressLint("CheckResult")
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<EpisodeData>) {
        service.getSouthParkEps().subscribe { result -> callback.onResult(result)}
    }

    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<EpisodeData>) {
        service.getSouthParkEps().subscribe { result -> callback.onResult(result)}
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<EpisodeData>) {
        // n/a
    }

    override fun getKey(item: EpisodeData): Int = item.id
}