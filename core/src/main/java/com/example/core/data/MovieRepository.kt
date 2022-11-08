package com.example.core.data

import com.example.core.data.source.local.LocalDataSource
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.data.source.remote.response.MovieItemResponse
import com.example.core.data.source.remote.service.ApiResponse
import com.example.core.domain.model.MovieModel
import com.example.core.domain.model.PopularMovieModel
import com.example.core.domain.repository.IMovieRepository
import com.example.core.utils.DataMapper
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : IMovieRepository {
    override fun getAllMovie(): Flow<Resource<List<MovieModel>>> =
        object : NetworkBoundResource<List<MovieModel>, List<MovieItemResponse>>() {
            override fun loadFromDB(): Flow<List<MovieModel>> {
                return localDataSource.getAllMovie().map {
                    DataMapper.mapEntitiesToDomainMovie(it)
                }
            }

            override fun shouldFetch(data: List<MovieModel>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MovieItemResponse>>> {
                return remoteDataSource.getAllMovie()
            }

            override suspend fun saveCallResult(data: List<MovieItemResponse>) {
                val movieList = DataMapper.mapResponsesToEntitiesMovie(data)
                localDataSource.insertMovie(movieList)
            }
        }.asFlow()

    override fun setFavoriteMovie(model: MovieModel, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(model)
        val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)
        coroutineScope.launch { localDataSource.setFavoriteMovie(movieEntity, state) }
    }

    override fun getFavoriteMovies(): Flow<List<MovieModel>> {
        return localDataSource.getFavoriteMovies().map {
            DataMapper.mapEntitiesToDomainMovie(it)
        }
    }

    override fun getPopularMovies(): Flow<Resource<List<PopularMovieModel>>> =
        object : NetworkBoundResource<List<PopularMovieModel>, List<MovieItemResponse>>() {
            override fun loadFromDB(): Flow<List<PopularMovieModel>> {
                return localDataSource.getAllPopularMovie().map {
                    DataMapper.mapEntitiesToDomainPopularMovie(it)
                }
            }

            override fun shouldFetch(data: List<PopularMovieModel>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MovieItemResponse>>> {
                return remoteDataSource.getPopularMovie()
            }

            override suspend fun saveCallResult(data: List<MovieItemResponse>) {
                val movieList = DataMapper.mapResponsesToEntitiesPopularMovie(data)
                localDataSource.insertPopularMovie(movieList)
            }
        }.asFlow()

}

