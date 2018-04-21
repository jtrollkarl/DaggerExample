package com.moducode.daggerexample.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moducode.daggerexample.R
import com.moducode.daggerexample.data.EpisodeData
import kotlinx.android.synthetic.main.episode_list_item.view.*

class EpisodeListRecycler(private val func: (EpisodeData) -> Unit): RecyclerView.Adapter<EpisodeListRecycler.EpisodeHolder>() {

    lateinit var data: List<EpisodeData>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.episode_list_item, parent, false)
        return EpisodeHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: EpisodeHolder, position: Int) {
        holder.bind(data[position], func)
    }
    
    class EpisodeHolder(view: View): RecyclerView.ViewHolder(view){

        fun bind(episode: EpisodeData, func: (EpisodeData) -> Unit){
            itemView.tv_episode_title.text = episode.name
            itemView.setOnClickListener { func(episode) }
        }

    }

}