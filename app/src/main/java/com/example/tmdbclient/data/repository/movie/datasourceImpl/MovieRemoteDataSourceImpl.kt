package com.example.tmdbclient.data.repository.movie.datasourceImpl

import android.util.Log
import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        Log.i("DataLog","remote datasource was used")
        return tmdbService.getPopularMovies(apiKey)

    }


}