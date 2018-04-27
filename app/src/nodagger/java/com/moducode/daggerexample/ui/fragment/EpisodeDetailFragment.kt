package com.moducode.daggerexample.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.moducode.daggerexample.R
import com.moducode.daggerexample.data.EpisodeData
import kotlinx.android.synthetic.nodagger.fragment_episode_detail.*


class EpisodeDetailFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_episode_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val episode = it.getParcelable<EpisodeData>(ARG_EPISODE)
            Glide.with(this).load(episode.image.original).into(iv_episode_cover)
            tv_episode_title.text = episode.name
            tv_episode_description.text = episode.summary
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
