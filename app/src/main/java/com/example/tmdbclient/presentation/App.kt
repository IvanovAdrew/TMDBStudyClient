package com.example.tmdbclient.presentation

import android.app.Application
import com.example.tmdbclient.presentation.di.Injector
import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.core.AppComponent
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvShow.TvShowSubComponent

class App:Application(),Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        //appComponent =
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        TODO("Not yet implemented")
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        TODO("Not yet implemented")
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        TODO("Not yet implemented")
    }
}