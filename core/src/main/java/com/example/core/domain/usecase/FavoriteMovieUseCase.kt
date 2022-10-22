package com.example.core.domain.usecase

import com.example.core.domain.model.MovieModel
import com.example.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IFavoriteMoviesUseCase {
    fun execute(): Flow<List<MovieModel>>
}

class FavoriteMoviesUseCase @Inject constructor(
    private val repository: IMovieRepository
) : IFavoriteMoviesUseCase {

    override fun execute(): Flow<List<MovieModel>> {
        return repository.getFavoriteMovies()
    }
}

interface ISetFavoriteMoviesUseCase {
    fun execute(model: MovieModel, state: Boolean)
}

class SetFavoriteMoviesUseCase @Inject constructor(
    private val repository: IMovieRepository
) : ISetFavoriteMoviesUseCase {

    override fun execute(model: MovieModel, state: Boolean) =
        repository.setFavoriteMovie(model, state)
}

