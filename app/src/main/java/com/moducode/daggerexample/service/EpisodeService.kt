package com.moducode.daggerexample.service

import com.moducode.daggerexample.data.EpisodeData
import io.reactivex.Single
import retrofit2.http.GET

interface EpisodeService {

    @GET("shows/112/episodes")
    fun getSouthParkEps(): Single<List<EpisodeData>>

}