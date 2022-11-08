package com.example.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.R
import com.example.core.domain.model.PopularMovieModel

class PopularMovieAdapter (private val dataSet: ArrayList<PopularMovieModel>) :
    RecyclerView.Adapter<PopularMovieAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleMovie: TextView
        val imageMovie: ImageView
        val popularityMovie: TextView
        val dateReleaseMovie: TextView


        init {
            titleMovie = view.findViewById(R.id.titleMovie)
            imageMovie = view.findViewById(R.id.imageMovie)
            popularityMovie = view.findViewById(R.id.popularityMovie)
            dateReleaseMovie = view.findViewById(R.id.releaseDateMovie)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.popular_movie_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]
        viewHolder.titleMovie.text = item.title
        Glide.with(viewHolder.itemView.context)
            .load("https://image.tmdb.org/t/p/original/"+item.image)
            .into(viewHolder.imageMovie)
        viewHolder.popularityMovie.text = item.popularity.toString()
        viewHolder.dateReleaseMovie.text = item.release_date
    }

    override fun getItemCount() = dataSet.size

}