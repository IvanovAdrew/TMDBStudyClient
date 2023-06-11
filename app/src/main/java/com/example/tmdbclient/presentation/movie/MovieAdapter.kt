package com.example.tmdbclient.presentation.movie

import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.databinding.ListItemBinding

class MovieAdapter {

}

class MyViewHolder(val  binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(movie: Movie){
        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview
        val posterURL = movie.posterPath
    }

}