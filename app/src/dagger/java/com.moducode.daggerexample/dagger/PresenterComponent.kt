package com.moducode.daggerexample.dagger

import com.moducode.daggerexample.ui.fragment.EpisodeListPresenter
import dagger.Subcomponent

@PresenterScope
@Subcomponent(modules = [EpisodeServiceModule::class])
interface PresenterComponent {


    fun buildEpisodeListPresenter(): EpisodeListPresenter


}