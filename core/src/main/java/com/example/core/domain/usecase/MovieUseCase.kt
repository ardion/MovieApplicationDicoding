package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.MovieModel
import com.example.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface IMovieUseCase {
    fun execute(): Flow<Resource<List<MovieModel>>>
}

class MovieUseCase @Inject constructor(
    private val repository: IMovieRepository
) : IMovieUseCase {

    override fun execute(): Flow<Resource<List<MovieModel>>> {
        return repository.getAllMovie()
    }
}