package com.example.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.R
import com.example.core.domain.model.MovieModel

class MovieAdapter(private val dataSet: ArrayList<MovieModel>, val listener: OnClickViewListener) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleMoview: TextView
        val imageMovie: ImageView

        init {
            titleMoview = view.findViewById(R.id.titleMovie)
            imageMovie= view.findViewById(R.id.imageMovie)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movie_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]
        viewHolder.titleMoview.text = item.title
        Glide.with(viewHolder.itemView.context)
            .load("https://image.tmdb.org/t/p/original/"+item.image)
            .into(viewHolder.imageMovie)

        viewHolder.itemView.setOnClickListener{
            listener.onClick(item)
        }
    }

    override fun getItemCount() = dataSet.size

    interface OnClickViewListener {
        fun onClick(data:MovieModel)
    }

}