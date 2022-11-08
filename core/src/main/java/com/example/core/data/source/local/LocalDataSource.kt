package com.example.core.data.source.local

import com.example.core.data.source.local.entiti.MovieEntity
import com.example.core.data.source.local.entiti.PopularMovieEntity
import com.example.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getAllMovie(): Flow<List<MovieEntity>> = movieDao.getAllMovie()
    fun getAllPopularMovie(): Flow<List<PopularMovieEntity>> = movieDao.getAllPopularMovie()

    suspend fun insertMovie(movieList: List<MovieEntity>) = movieDao.insertMovie(movieList)
    suspend fun insertPopularMovie(movieList: List<PopularMovieEntity>) = movieDao.insertPopularMovie(movieList)

    suspend fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }

    fun getFavoriteMovies(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovies()
}