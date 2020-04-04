package com.example.popularmovies.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.popularmovies.R
import com.example.popularmovies.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter (private val movie: List<Movie>, private val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val baseUrl = MovieAPI.imageBaseUrl
    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        )
    }


    override fun getItemCount(): Int = movie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movie[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onClick(movie[adapterPosition]) }
        }

        fun bind(movie: Movie) {
            itemView.etText.text = "${(adapterPosition + 1)}."
            Glide.with(context).load(baseUrl + movie.posterPath).into(itemView.ivMovie)
        }
    }
}