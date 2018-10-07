package com.moducode.daggerexample.ui.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.moducode.daggerexample.R
import com.moducode.daggerexample.data.EpisodeData

class EpisodePagedAdapter(private val func: (EpisodeData?) -> Unit) : PagedListAdapter<EpisodeData, EpisodeListRecycler.EpisodeHolder>(CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeListRecycler.EpisodeHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.episode_list_item, parent, false)
        return EpisodeListRecycler.EpisodeHolder(v)
    }

    override fun onBindViewHolder(holder: EpisodeListRecycler.EpisodeHolder, position: Int) {
        holder.bind(getItem(position), func)
    }

    private companion object {
        val CALLBACK = object : DiffUtil.ItemCallback<EpisodeData>() {
            override fun areItemsTheSame(oldItem: EpisodeData?, newItem: EpisodeData?): Boolean = oldItem?.id == newItem?.id

            override fun areContentsTheSame(oldItem: EpisodeData?, newItem: EpisodeData?): Boolean = oldItem?.name == newItem?.name
        }
    }



}