package com.example.core.data.source.remote

import com.example.core.data.source.remote.response.MovieItemResponse
import com.example.core.data.source.remote.service.ApiResponse
import com.example.core.data.source.remote.service.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val movieService: MovieService
) {

    suspend fun getAllMovie(): Flow<ApiResponse<List<MovieItemResponse>>> {
        return flow {
            try {
                val response = movieService.getMovies()
                if (response.results.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPopularMovie(): Flow<ApiResponse<List<MovieItemResponse>>> {
        return flow {
            try {
                val response = movieService.getPopularMovies()
                if (response.results.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

}