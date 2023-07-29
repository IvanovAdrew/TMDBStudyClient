package com.example.tmdbclient.data.repository.movie

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.domain.repository.MovieRepository

class FakeMovieRepository: MovieRepository {
    private val movies = mutableListOf<Movie>()
    init {
        movies.add(Movie(1,"overview1", 123.0, "posterPath1", "date1", "kino1",5.0, 40))
        movies.add(Movie(2,"overview2", 223.0, "posterPath2", "date2", "kino2",6.0, 80))
    }
    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(3,"overview3", 423.0, "posterPath3", "date3", "kino3",7.0, 120))
        movies.add(Movie(4,"overview4", 323.0, "posterPath4", "date4", "kino4",8.0, 100))
        return movies
    }
}