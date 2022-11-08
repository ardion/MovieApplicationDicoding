package com.example.core.domain.repository

import com.example.core.data.Resource
import com.example.core.domain.model.MovieModel
import com.example.core.domain.model.PopularMovieModel
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllMovie(): Flow<Resource<List<MovieModel>>>
    fun setFavoriteMovie(model: MovieModel, state: Boolean)
    fun getFavoriteMovies(): Flow<List<MovieModel>>
    fun getPopularMovies(): Flow<Resource<List<PopularMovieModel>>>
}