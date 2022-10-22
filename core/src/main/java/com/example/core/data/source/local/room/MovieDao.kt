package com.example.core.data.source.local.room

import androidx.room.*
import com.example.core.data.source.local.entiti.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllMovie(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(tourism: List<MovieEntity>)

    @Update
    suspend fun updateFavoriteMovie(tourism: MovieEntity)

    @Query("SELECT * FROM movie where isFavorite = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>
}
