package com.moducode.daggerexample.ui.activity


import android.support.v4.app.Fragment
import com.moducode.daggerexample.data.EpisodeData
import com.moducode.daggerexample.ui.fragment.EpisodeListFragment

class MainActivity : SingleFragmentActivity(), EpisodeListFragment.Callbacks {

    override val fragment: Fragment = TODO("Implement fragment")

    override fun onEpisodeClick(data: EpisodeData) {
        TODO("implement new fragment with args")
    }
}
