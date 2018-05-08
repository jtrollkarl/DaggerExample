package com.moducode.daggerexample.ui.activity

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.moducode.daggerexample.data.EpisodeData
import com.moducode.daggerexample.ui.fragment.EpisodeDetailFragment

class EpisodeDetailContainer: SingleFragmentActivity() {

    override fun getFragment(): Fragment {
        val data = intent.getParcelableExtra<EpisodeData>(EpisodeDetailFragment.ARG_EPISODE)
        return EpisodeDetailFragment.newInstance(data)
    }

    companion object {
        fun newIntent(context: Context, data: EpisodeData): Intent{
            return Intent(context, EpisodeDetailContainer::class.java).apply { putExtra(EpisodeDetailFragment.ARG_EPISODE, data) }
        }
    }
}