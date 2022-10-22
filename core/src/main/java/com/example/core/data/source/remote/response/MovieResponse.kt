package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetMoviesResponse(
    val page: Int,
    val results: List<MovieItemResponse>
)

data class MovieItemResponse(
    val id: Int,
    @SerializedName("poster_path")
    val image: String,
    @SerializedName("title")
    val title: String,
    val overview: String,
    val popularity: Float,
    val release_date: String
)