package com.moducode.daggerexample.ui.activity

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.moducode.daggerexample.data.EpisodeData
import com.moducode.daggerexample.ui.fragment.ARG_EPISODE
import com.moducode.daggerexample.ui.fragment.EpisodeDetailFragment

class EpisodeDetailContainer: AppCompatActivity() {


    companion object {

        fun newIntent(context: Context, data: EpisodeData): Intent{
            return Intent(context, EpisodeDetailContainer::class.java).apply { putExtra(ARG_EPISODE, data) }
        }
    }
}