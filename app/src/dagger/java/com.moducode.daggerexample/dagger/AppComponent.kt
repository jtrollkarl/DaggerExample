package com.moducode.daggerexample.dagger


import com.moducode.daggerexample.room.DbRepo
import com.moducode.daggerexample.service.EpisodeService
import com.moducode.daggerexample.ui.fragment.EpisodeDetailPresenter
import com.moducode.daggerexample.ui.fragment.EpisodeListPresenter
import dagger.Component
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Singleton
@Component(modules = [SchedulerModule::class, DatabaseModule::class, EpisodeServiceModule::class])
interface AppComponent {

    fun buildEpisodeDetailPresenter(): EpisodeDetailPresenter

    fun buildEpisodeListPresenter(): EpisodeListPresenter

    //these 3 functions returning dependencies are only used for demonstration purposes
    fun okHttpClient(): OkHttpClient

    fun episodeService(): EpisodeService

    fun dbRepo(): DbRepo

}
