//package com.example.coba
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import androidx.activity.viewModels
//import com.example.coba.databinding.ActivityCobaBinding
//import com.example.core.data.Resource
//import com.example.core.domain.model.MovieModel
//import com.example.core.ui.MovieAdapter
//import com.example.core.ui.showSnackbar
//import dagger.hilt.android.AndroidEntryPoint
//
////@AndroidEntryPoint
//class CobaActivity : AppCompatActivity(), MovieAdapter.OnClickViewListener {
//    private lateinit var binding: ActivityCobaBinding
//
////    private val viewModel:CobaViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityCobaBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
////        setUpObserver()
//
//    }
//
////    private fun setUpObserver() {
////        viewModel.favoriteMovies.observe(this) { movies ->
////            if (movies != null) {
////                when (movies) {
////                    is Resource.Loading -> {
////                        binding.progressBar.visibility = View.VISIBLE
////                    }
////                    is Resource.Success -> {
////                        binding.progressBar.visibility = View.GONE
////                        binding.rvMovie.apply {
////                            adapter = MovieAdapter(movies.data as ArrayList<MovieModel>, this@CobaActivity)
////                        }
////                    }
////                    is Resource.Error -> {
////                        binding.progressBar.visibility = View.GONE
////                        showSnackbar(binding.root, this)
////                    }
////                }
////            }
////        }
////    }
//
//    override fun onClick(data: MovieModel) {
//        TODO("Not yet implemented")
//    }
//}