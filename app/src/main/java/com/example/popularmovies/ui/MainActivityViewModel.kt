package com.example.popularmovies.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.popularmovies.data.MovieRepository
import com.example.popularmovies.model.Movie
import com.example.popularmovies.model.MovieByYear
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.Year

class MainActivityViewModel (application: Application) : AndroidViewModel(application){
    private val movieRepository: MovieRepository = MovieRepository()
    val movie = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()
    val year = MutableLiveData<Int>()

    fun getMoviesByReleaseYear(year: Int?) {
        movieRepository.getMovieList(year!!).enqueue(object : Callback<MovieByYear> {
            override fun onResponse(call: Call<MovieByYear>, response: Response<MovieByYear>) {
                if (response.isSuccessful) movie.value = response.body()?.MoviesByYear
                else error.value = "An error occurred: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<MovieByYear>, t: Throwable) {
                error.value = t.message
            }
        })
    }
    }