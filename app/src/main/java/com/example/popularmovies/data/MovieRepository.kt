package com.example.popularmovies.data

import com.example.popularmovies.model.Movie
import com.example.popularmovies.model.MovieByYear
import retrofit2.Call

class MovieRepository {
    private val movieApi: MovieApiService = MovieAPI.createApi()

    fun getMovieList(year: Int):Call<MovieByYear> = movieApi.getMoviByYear(year)
}