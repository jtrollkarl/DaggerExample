package com.moducode.daggerexample.ui.fragment

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.moducode.daggerexample.data.EpisodeData

class EpisodeDetailPresenter :
        MvpBasePresenter<EpisodeDetailContract.View>(),
        EpisodeDetailContract.Actions {



    override fun saveEpisode(episodeData: EpisodeData) {

    }
}