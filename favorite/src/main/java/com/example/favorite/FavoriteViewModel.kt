package com.example.favorite

import androidx.lifecycle.*
import com.example.core.domain.usecase.IFavoriteMoviesUseCase


class FavoriteViewModel(
    favoriteMovieUseCase: IFavoriteMoviesUseCase
) : ViewModel() {
    val favoriteMovies = favoriteMovieUseCase.execute().asLiveData()
}