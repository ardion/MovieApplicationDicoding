package com.example.movieapplicationdicoding.di

import com.example.core.domain.usecase.IFavoriteMoviesUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun favoriteUseCAse(): IFavoriteMoviesUseCase
}