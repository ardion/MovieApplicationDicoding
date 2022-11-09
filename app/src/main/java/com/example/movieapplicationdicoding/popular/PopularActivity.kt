package com.example.movieapplicationdicoding.popular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.core.data.Resource
import com.example.core.domain.model.PopularMovieModel
import com.example.core.ui.PopularMovieAdapter
import com.example.core.ui.showSnackbar
import com.example.movieapplicationdicoding.databinding.ActivityPopularBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPopularBinding
    private val viewModel: PopularMovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopularBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        viewModel.movies.observe(this) { movies ->
            if (movies != null) {
                when (movies) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rvPopularMovie.apply {
                            adapter = PopularMovieAdapter(
                                movies.data as ArrayList<PopularMovieModel>
                            )
                        }
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        showSnackbar(binding.root, this)
                    }
                }
            }
        }
    }
}