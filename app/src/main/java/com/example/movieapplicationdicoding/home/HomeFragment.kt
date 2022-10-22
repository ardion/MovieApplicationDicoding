package com.example.movieapplicationdicoding.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.core.data.Resource
import com.example.core.domain.model.MovieModel
import com.example.core.ui.MovieAdapter
import com.example.core.ui.showSnackbar
import com.example.movieapplicationdicoding.databinding.FragmentHomeBinding
import com.example.movieapplicationdicoding.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), MovieAdapter.OnClickViewListener {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    companion object {
        const val ARG_DETAIL_PARAM = "detail_param"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            if (movies != null) {
                when (movies) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rvMovie.apply {
                            adapter = MovieAdapter(
                                movies.data as ArrayList<MovieModel>,
                                this@HomeFragment
                            )
                        }
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        showSnackbar(binding.root, requireContext())
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onClick(data: MovieModel) {
        val intent = DetailActivity.getIntent(requireContext()).apply {
            putExtra(ARG_DETAIL_PARAM, data)
        }
        startActivity(intent)
    }

}