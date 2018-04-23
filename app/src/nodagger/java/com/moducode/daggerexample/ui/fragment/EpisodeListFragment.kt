package com.moducode.daggerexample.ui.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.moducode.daggerexample.R
import com.moducode.daggerexample.data.EpisodeData
import com.moducode.daggerexample.ui.adapter.EpisodeListRecycler
import kotlinx.android.synthetic.main.fragment_episode_list.*

class EpisodeListFragment : Fragment() {

    interface Callbacks{
        fun onEpisodeClick(data: EpisodeData)
    }

    private lateinit var listener: Callbacks

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as Callbacks
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_episode_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = EpisodeListRecycler { listener.onEpisodeClick(it) }
        val lm = LinearLayoutManager(context)

        recycler_episodes.adapter = adapter
        recycler_episodes.layoutManager = lm
        recycler_episodes.addItemDecoration(DividerItemDecoration(context, lm.orientation))

    }
}
