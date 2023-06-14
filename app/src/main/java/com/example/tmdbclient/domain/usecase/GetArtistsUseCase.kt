package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()
    suspend fun executeSorted(): List<Artist>? {
        return artistRepository.getArtists()?.sortedWith(compareBy { it.popularity })?.reversed()
    }
}