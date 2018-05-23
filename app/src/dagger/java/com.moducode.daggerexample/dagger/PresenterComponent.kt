package com.moducode.daggerexample.dagger

import com.moducode.daggerexample.ui.fragment.EpisodeDetailPresenter
import com.moducode.daggerexample.ui.fragment.EpisodeListPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SchedulerModule::class, DatabaseModule::class, EpisodeServiceModule::class])
interface PresenterComponent {

    fun buildEpisodeDetailPresenter(): EpisodeDetailPresenter

    fun buildEpisodeListPresenter(): EpisodeListPresenter

}