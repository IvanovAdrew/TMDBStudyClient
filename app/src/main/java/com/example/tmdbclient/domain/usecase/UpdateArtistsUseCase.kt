package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
    suspend fun executeSorted(): List<Artist>? {
        return artistRepository.updateArtists()?.sortedWith(compareBy { it.popularity })?.reversed()
    }
}