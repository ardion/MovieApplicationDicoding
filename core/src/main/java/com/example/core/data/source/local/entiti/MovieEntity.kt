package com.example.core.data.source.local.entiti

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "popularity")
    var popularity: Float,

    @ColumnInfo(name = "release_date")
    var release_date: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)

@Entity(tableName = "movie_popular")
data class PopularMovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "popularity")
    var popularity: Float,

    @ColumnInfo(name = "release_date")
    var release_date: String,
)

