package com.example.popularmovies.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MovieAPI {
    companion object {
        private const val baseUrl = "https://api.themoviedb.org/3/discover/"
        val imageBaseUrl = "https://image.tmdb.org/t/p/w500/"

        fun createApi(): MovieApiService{
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            val numbersApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return numbersApi.create(MovieApiService::class.java)
        }

    }

}