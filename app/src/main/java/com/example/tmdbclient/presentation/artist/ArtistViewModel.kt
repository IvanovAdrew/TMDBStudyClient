package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
):ViewModel() {
    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.executeSorted()
        emit(artistList)
    }
    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.executeSorted()
        emit(artistList)
    }
}