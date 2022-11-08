package com.example.movieapplicationdicoding.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.core.domain.model.MovieModel
import com.example.movieapplicationdicoding.R
import com.example.movieapplicationdicoding.databinding.ActivityDetailBinding
import com.example.movieapplicationdicoding.home.HomeFragment.Companion.ARG_DETAIL_PARAM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var binding: ActivityDetailBinding
    lateinit var movieModel: MovieModel
    var isfavorite: Boolean = false

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, DetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        intent.extras?.getParcelable<MovieModel>(ARG_DETAIL_PARAM)?.run {
            with(binding) {
                Glide.with(this@DetailActivity)
                    .load("https://image.tmdb.org/t/p/original/" + this@run.image)
                    .into(imageMovie)
                tvTitle.text = this@run.title
                tvOverview.text = this@run.overview
                tvPopularity.text = this@run.popularity.toString()
                tvDateRelease.text = this@run.release_date
                isfavorite = this@run.isFavorite
                setStatusFavorite(this@run.isFavorite)
                movieModel = this@run
            }
        }
        binding.fab.setOnClickListener {
            isfavorite = !isfavorite
            setStatusFavorite(isfavorite)
            viewModel.setFavoriteMovie(movieModel, isfavorite)
        }
    }


    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_not_favorite_white
                )
            )
        }
    }
}