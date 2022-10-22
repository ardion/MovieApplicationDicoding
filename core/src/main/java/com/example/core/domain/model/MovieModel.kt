package com.example.core.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
@Parcelize
data class MovieModel(
    val id:Int,
    @SerializedName("poster_path")
    val image: String,
    @SerializedName("title")
    val title: String,
    val overview: String,
    val popularity: Float,
    val release_date: String,
    val isFavorite: Boolean
):Parcelable
