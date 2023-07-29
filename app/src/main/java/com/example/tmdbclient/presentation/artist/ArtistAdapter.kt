package com.example.tmdbclient.presentation.artist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.databinding.ListItemBinding
import com.example.tmdbclient.databinding.ListItemForActorsBinding

class ArtistAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<Artist>()
    fun setList(artists: List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemForActorsBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_for_actors,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

}

class MyViewHolder(val  binding: ListItemForActorsBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(artist: Artist){
        Log.i("MYTAG",artist.name.toString())
        binding.titleTextView.text = artist.name.toString()
        binding.popularityTextView.text = "Popularity: "+artist.popularity.toString()
        val posterURL = "https://image.tmdb.org/t/p/w500"+artist.profilePath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }

}