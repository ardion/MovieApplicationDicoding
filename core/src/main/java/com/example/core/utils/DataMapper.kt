package com.example.core.utils

import com.example.core.data.source.local.entiti.MovieEntity
import com.example.core.data.source.remote.response.MovieItemResponse
import com.example.core.domain.model.MovieModel

object DataMapper {
    fun mapResponsesToEntitiesMovie(input: List<MovieItemResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                title = it.title,
                movieId = it.id,
                image = it.image,
                overview = it.overview,
                popularity = it.popularity,
                release_date = it.release_date
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapResponsesToEntitiesFavoriteMovie(input: List<MovieItemResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                title = it.title,
                movieId = it.id,
                image = it.image,
                overview = it.overview,
                popularity = it.popularity,
                release_date = it.release_date
            )
            movieList.add(movie)
        }
        return movieList
    }


    fun mapEntitiesToDomainMovie(input: List<MovieEntity>): List<MovieModel> =
        input.map {
            MovieModel(
                id = it.movieId,
                title = it.title,
                image = it.image,
                overview = it.overview,
                release_date = it.release_date,
                popularity = it.popularity,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: MovieModel) = MovieEntity(
        movieId = input.id,
        title = input.title,
        image = input.image,
        overview = input.overview,
        release_date = input.release_date,
        popularity = input.popularity,
        isFavorite = input.isFavorite
    )

}