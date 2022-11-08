package com.example.core.utils

import com.example.core.data.source.local.entiti.MovieEntity
import com.example.core.data.source.local.entiti.PopularMovieEntity
import com.example.core.data.source.remote.response.MovieItemResponse
import com.example.core.domain.model.MovieModel
import com.example.core.domain.model.PopularMovieModel

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

    fun mapResponsesToEntitiesPopularMovie(input: List<MovieItemResponse>): List<PopularMovieEntity> {
        val movieList = ArrayList<PopularMovieEntity>()
        input.map {
            val movie = PopularMovieEntity(
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


    fun mapEntitiesToDomainPopularMovie(input: List<PopularMovieEntity>): List<PopularMovieModel> =
        input.map {
            PopularMovieModel(
                id = it.movieId,
                title = it.title,
                image = it.image,
                overview = it.overview,
                release_date = it.release_date,
                popularity = it.popularity
            )
        }
}