package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.PopularMovieModel
import com.example.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IPopularMovieUseCase {
    fun execute(): Flow<Resource<List<PopularMovieModel>>>
}

class PopularMovieUseCase @Inject constructor(
    private val repository: IMovieRepository
) : IPopularMovieUseCase {

    override fun execute(): Flow<Resource<List<PopularMovieModel>>> {
        return repository.getPopularMovies()
    }
}