package com.example.core.data.source.local.room

import androidx.room.*
import com.example.core.data.source.local.entiti.MovieEntity
import com.example.core.data.source.local.entiti.PopularMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie_popular")
    fun getAllPopularMovie(): Flow<List<PopularMovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovie(movie: List<PopularMovieEntity>)

    @Update
    suspend fun updateFavoriteMovie(movie: MovieEntity)

    @Query("SELECT * FROM movie where isFavorite = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>
}
