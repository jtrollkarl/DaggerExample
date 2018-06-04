package com.moducode.daggerexample.dagger


import com.moducode.daggerexample.ui.fragment.EpisodeDetailPresenter
import dagger.Component

@AppScope
@Component(modules = [SchedulerModule::class, DatabaseModule::class])
interface AppComponent {

    fun buildPresenterComponent(): PresenterComponent

    fun buildEpisodeDetailPresenter(): EpisodeDetailPresenter

}
