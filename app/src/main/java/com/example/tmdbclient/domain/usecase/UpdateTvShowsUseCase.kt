package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()
    suspend fun executeSorted(): List<TvShow>? {
        return tvShowRepository.updateTvShows()?.sortedWith(compareBy { it.popularity })?.reversed()
    }
}