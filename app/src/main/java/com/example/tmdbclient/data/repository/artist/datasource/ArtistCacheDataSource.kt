package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun saveArtistsToCache(artists: List<Artist>)
    suspend fun getArtistsFromCache():List<Artist>
}