package com.example.popularmovies.model

import com.google.gson.annotations.SerializedName

@Suppress("ArrayInDataClass")
data class MovieByYear (
    @SerializedName("results") var MoviesByYear: List<Movie>
)