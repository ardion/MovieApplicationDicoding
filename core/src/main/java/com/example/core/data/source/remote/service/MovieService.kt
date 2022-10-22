package com.example.core.data.source.remote.service

import com.example.core.data.source.remote.response.GetMoviesResponse
import retrofit2.http.GET

interface MovieService {
    @GET("/3/movie/now_playing?api_key=74078d381713cfc6b144cc4fc1e7aaef")
    suspend fun getMovies(): GetMoviesResponse
}