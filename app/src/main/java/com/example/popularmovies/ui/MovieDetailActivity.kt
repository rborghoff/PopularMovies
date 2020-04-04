package com.example.popularmovies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.popularmovies.R
import com.example.popularmovies.data.MovieAPI
import com.example.popularmovies.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"
        initViews()
    }


    private fun initViews(){
        val item = intent.extras
        if(item != null){
            val movie: Movie = item.get("Movie") as Movie
            Glide.with(this).load(MovieAPI.imageBaseUrl + movie.backdropPath).into(ivLarge)
            Glide.with(this).load(MovieAPI.imageBaseUrl + movie.posterPath).into(ivSmall)
            tvTitle.text = movie.title
            tvRating.text = movie.rating.toString()
            tvRelease.text = getString(R.string.release,movie.releaseDate)
            tvText.text = movie.overView
        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return try {
            finish()
            true
        } catch (exception: Exception) {
            false
        }
    }

}
