package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
    suspend fun executeSorted(): List<TvShow>? {
        return tvShowRepository.getTvShows()?.sortedWith(compareBy { it.popularity })?.reversed()
    }
}