package com.moducode.daggerexample.dagger

import com.moducode.daggerexample.room.DbRepo
import com.moducode.daggerexample.service.EpisodeService
import com.moducode.daggerexample.ui.fragment.EpisodeDetailPresenter
import com.moducode.daggerexample.ui.fragment.EpisodeListPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SchedulerModule::class, DatabaseModule::class, EpisodeServiceModule::class])
interface PresenterComponent {

    fun buildEpisodeDetailPresenter(): EpisodeDetailPresenter

    fun buildEpisodeListPresenter(): EpisodeListPresenter

    //these functions are used for demonstrating scoping; not used in the project
    fun getDb(): DbRepo

    fun getEpisodeService(): EpisodeService

}