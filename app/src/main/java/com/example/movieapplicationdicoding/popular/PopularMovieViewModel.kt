package com.example.movieapplicationdicoding.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.IPopularMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularMovieViewModel @Inject constructor(
    popularMovieUseCase: IPopularMovieUseCase
) : ViewModel() {
    val movies = popularMovieUseCase.execute().asLiveData()
}