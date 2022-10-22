package com.example.movieapplicationdicoding.detail

import androidx.lifecycle.ViewModel
import com.example.core.domain.model.MovieModel
import com.example.core.domain.usecase.ISetFavoriteMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel@Inject constructor(
 private val setFavoriteUseCase: ISetFavoriteMoviesUseCase
) : ViewModel() {
    fun setFavoriteMovie(model: MovieModel, newStatus:Boolean) =
        setFavoriteUseCase.execute(model, newStatus)
}