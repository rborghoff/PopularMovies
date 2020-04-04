package com.example.popularmovies.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Movie (
    @SerializedName("original_title") var title: String,
    @SerializedName("vote_average") var rating: Double,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("overview") var overView: String,
    @SerializedName("backdrop_path") var backdropPath: String,
    @SerializedName("poster_path") var posterPath: String
    ):Parcelable