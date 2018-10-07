package com.moducode.daggerexample.ui.fragment


import android.arch.paging.PagedList
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.hannesdorfmann.mosby3.mvp.MvpFragment

import com.moducode.daggerexample.R
import com.moducode.daggerexample.buildPresenter
import com.moducode.daggerexample.data.EpisodeData
import com.moducode.daggerexample.shortToast
import com.moducode.daggerexample.ui.adapter.EpisodeListRecycler
import com.moducode.daggerexample.ui.adapter.EpisodePagedAdapter
import com.moducode.daggerexample.ui.fragment.contract.EpisodeListContract
import kotlinx.android.synthetic.main.fragment_episode_list.*

class EpisodeListFragment : MvpFragment<EpisodeListContract.View, EpisodeListContract.Actions>(), EpisodeListContract.View {

    interface Callbacks {
        fun onEpisodeClick(data: EpisodeData?)
    }

    companion object {
        const val KEY_FAVORITES = "key_favorites"
    }

    private lateinit var listener: Callbacks
    private lateinit var recyclerAdapter: EpisodePagedAdapter
    private var isFavoritesSelected: Boolean = false


    override fun createPresenter(): EpisodeListContract.Actions = buildPresenter()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as Callbacks
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_episode_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        isFavoritesSelected = savedInstanceState?.let {
            it.takeIf {
                it.containsKey(KEY_FAVORITES)
            }?.getBoolean(KEY_FAVORITES)
        } ?: false

        val lm = LinearLayoutManager(context)
        recycler_episodes.apply {
            layoutManager = lm
            addItemDecoration(DividerItemDecoration(context, lm.orientation))
        }
    }

    override fun onResume() {
        super.onResume()
        fetchEpisodes()
    }

    private fun fetchEpisodes() {
        if (isFavoritesSelected) presenter.fetchFavourites() else presenter.fetchEpisodes()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.episode_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
            when (item?.itemId) {
                R.id.menu_filter_fav -> {
                    isFavoritesSelected = true
                    fetchEpisodes()
                    true
                }
                R.id.menu_filter_all -> {
                    isFavoritesSelected = false
                    fetchEpisodes()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_FAVORITES, isFavoritesSelected)
    }

    override fun handleEpisodeClick(episode: EpisodeData) {
        listener.onEpisodeClick(episode)
    }

    override fun setData(data: PagedList<EpisodeData>) {
        recyclerAdapter = EpisodePagedAdapter { listener.onEpisodeClick(it) }
        recycler_episodes.adapter = recyclerAdapter
        recyclerAdapter.submitList(data)
    }

    override fun showError(error: Throwable) {
        shortToast(error.message)
    }

}
