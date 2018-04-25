package com.moducode.daggerexample.ui.activity


import android.support.v4.app.Fragment
import com.moducode.daggerexample.data.EpisodeData
import com.moducode.daggerexample.ui.fragment.EpisodeListFragment

class EpisodeListContainer : SingleFragmentActivity(), EpisodeListFragment.Callbacks {

    override fun getFragment(): Fragment = EpisodeListFragment()

    override fun onEpisodeClick(data: EpisodeData) {
        startActivity(EpisodeDetailContainer.newIntent(this, data))
    }
}
