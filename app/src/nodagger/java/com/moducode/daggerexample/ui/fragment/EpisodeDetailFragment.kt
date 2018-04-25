package com.moducode.daggerexample.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.moducode.daggerexample.R
import com.moducode.daggerexample.data.EpisodeData


const val ARG_EPISODE = "key_episode"

class EpisodeDetailFragment : Fragment() {

    private var episode: EpisodeData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        episode = arguments?.getParcelable(ARG_EPISODE)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_episode_detail, container, false)
    }

    companion object {

        fun newInstance(episodeData: EpisodeData) = EpisodeDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_EPISODE, episodeData)
            }
        }
    }
}
