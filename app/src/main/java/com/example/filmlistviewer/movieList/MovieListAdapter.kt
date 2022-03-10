package com.example.filmlistviewer.movieList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmlistviewer.R
import com.example.filmlistviewer.data.Result

class MovieListAdapter :
    PagingDataAdapter<Result, MovieListAdapter.MovieViewHolder>(MovieDifUtilCallback) {
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val filmTitleTextView: TextView = itemView.findViewById(R.id.film_title)
        private val filmDescriptionTextView: TextView = itemView.findViewById(R.id.film_description)
        private val filmCoverImageView: ImageView = itemView.findViewById(R.id.film_cover)
        private var currentMovie: Result? = null

        fun bind(item: Result?) {
            currentMovie = item
            filmTitleTextView.text = item?.display_title
            filmDescriptionTextView.text = item?.summary_short
            Glide.with(filmCoverImageView)
                .load(item?.multimedia?.src)
                .into(filmCoverImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_view, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(movieViewHolder: MovieViewHolder, position: Int) {
        movieViewHolder.bind(getItem(position))
    }

    object MovieDifUtilCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.display_title == newItem.display_title
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.display_title == newItem.display_title
        }
    }
}