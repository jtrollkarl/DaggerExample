package com.moducode.daggerexample.ui.fragment.contract

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.moducode.daggerexample.data.EpisodeData

interface EpisodeListContract {

    interface View: MvpView{
        fun setData(data: List<EpisodeData>)
        fun handleEpisodeClick(episode: EpisodeData)
        fun showError(error: Throwable)
    }

    interface Actions: MvpPresenter<View> {
        fun fetchEpisodes()
        fun fetchFavourites()
    }

}