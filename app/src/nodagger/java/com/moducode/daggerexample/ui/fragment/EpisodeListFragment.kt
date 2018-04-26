package com.moducode.daggerexample.ui.fragment


import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpFragment

import com.moducode.daggerexample.R
import com.moducode.daggerexample.data.EpisodeData
import com.moducode.daggerexample.schedulers.SchedulersImpl
import com.moducode.daggerexample.service.EpisodeService
import com.moducode.daggerexample.service.RetrofitFactory
import com.moducode.daggerexample.shortToast
import com.moducode.daggerexample.ui.adapter.EpisodeListRecycler
import kotlinx.android.synthetic.main.fragment_episode_list.*

class EpisodeListFragment : MvpFragment<EpisodeListContract.View, EpisodeListContract.Actions>(), EpisodeListContract.View {

    interface Callbacks {
        fun onEpisodeClick(data: EpisodeData)
    }

    private lateinit var listener: Callbacks
    private lateinit var recyclerAdapter: EpisodeListRecycler

    override fun createPresenter(): EpisodeListContract.Actions {
         return EpisodeListPresenter(RetrofitFactory.create(context?.cacheDir!!, EpisodeService::class.java), SchedulersImpl())
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as Callbacks
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_episode_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lm = LinearLayoutManager(context)
        recycler_episodes.apply {
            layoutManager = lm
            addItemDecoration(DividerItemDecoration(context, lm.orientation))
        }
    }

    override fun handleEpisodeClick(episode: EpisodeData) {
        listener.onEpisodeClick(episode)
    }

    override fun setData(data: List<EpisodeData>) {
        recyclerAdapter = EpisodeListRecycler(data, {listener.onEpisodeClick(it)}).apply {
            notifyDataSetChanged()
        }
        recycler_episodes.adapter = recyclerAdapter
    }

    override fun showError(error: Throwable) {
        shortToast(error.message)
    }

    override fun onResume() {
        super.onResume()
        presenter.fetchEpisodes()
    }
}
