package com.example.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.data.source.local.entiti.MovieEntity
import com.example.core.data.source.local.entiti.PopularMovieEntity

@Database(entities = [MovieEntity::class, PopularMovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}