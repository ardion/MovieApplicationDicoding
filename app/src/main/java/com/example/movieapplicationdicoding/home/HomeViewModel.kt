package com.example.movieapplicationdicoding.home

import androidx.lifecycle.*
import com.example.core.domain.usecase.IMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    movieUseCase: IMovieUseCase
) : ViewModel() {
    val movies = movieUseCase.execute().asLiveData()
}