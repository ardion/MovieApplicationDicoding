package com.example.movieapplicationdicoding.di

import com.example.core.data.MovieRepository
import com.example.core.domain.repository.IMovieRepository
import com.example.core.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieModule {

    @Binds
    @Singleton
    abstract fun provideMovieUseCase(useCase: MovieUseCase): IMovieUseCase

    @Binds
    @Singleton
    abstract fun provideFavoriteMoviesUseCase(useCase: FavoriteMoviesUseCase): IFavoriteMoviesUseCase

    @Binds
    @Singleton
    abstract fun provideSetFavoriteMoviesUseCase(useCase: SetFavoriteMoviesUseCase): ISetFavoriteMoviesUseCase
}