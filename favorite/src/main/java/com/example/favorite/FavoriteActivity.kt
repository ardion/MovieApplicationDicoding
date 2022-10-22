package com.example.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.core.domain.model.MovieModel
import com.example.core.ui.MovieAdapter
import com.example.favorite.databinding.ActivityFavoriteBinding
import com.example.movieapplicationdicoding.detail.DetailActivity
import com.example.movieapplicationdicoding.di.FavoriteModuleDependencies
import com.example.movieapplicationdicoding.home.HomeFragment
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity(), MovieAdapter.OnClickViewListener {
    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var binding: ActivityFavoriteBinding

    private val viewModel: FavoriteViewModel by viewModels() {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpObserver()

    }

    private fun setUpObserver() {
        viewModel.favoriteMovies.observe(this) { movies ->
            binding.rvMovie.apply {
                adapter = MovieAdapter(
                    movies as ArrayList<MovieModel>,
                    this@FavoriteActivity
                )
            }
        }
    }

    override fun onClick(data: MovieModel) {
        val intent = DetailActivity.getIntent(this).apply {
            putExtra(HomeFragment.ARG_DETAIL_PARAM, data)
        }
        startActivity(intent)
    }
}