package com.moducode.daggerexample.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hannesdorfmann.mosby3.mvp.MvpFragment

import com.moducode.daggerexample.R
import com.moducode.daggerexample.data.EpisodeData
import kotlinx.android.synthetic.main.fragment_episode_detail.*


class EpisodeDetailFragment :
        MvpFragment<EpisodeDetailContract.View, EpisodeDetailContract.Actions>(),
        EpisodeDetailContract.View {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_episode_detail, container, false)
    }

    override fun createPresenter(): EpisodeDetailContract.Actions = EpisodeDetailPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val episode = it.getParcelable<EpisodeData>(ARG_EPISODE)
            Glide.with(this).load(episode.image.original).into(iv_episode_cover)
            tv_episode_title.text = episode.name
            tv_episode_description.text = Html.fromHtml(episode.summary)
            tv_episode_running_time.text = getString(R.string.tv_running_time, episode.runtime.toString())
            tv_episode_airdate.text = getString(R.string.tv_airdate, episode.airdate)

            fab_save_episode.setOnClickListener { presenter.saveEpisode(episode) }
        }

    }

    companion object {
        const val ARG_EPISODE = "key_episode"
        fun newInstance(episodeData: EpisodeData) = EpisodeDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_EPISODE, episodeData)
            }
        }
    }
}
