package com.example.popularmovies.data



import com.bumptech.glide.BuildConfig
import com.example.popularmovies.model.Movie
import com.example.popularmovies.model.MovieByYear
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie?api_key=fadda38ced220b057bba618d0167872b&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getMoviByYear(@Query(value = "primary_release_year",encoded = true)release: Int): Call<MovieByYear>


}