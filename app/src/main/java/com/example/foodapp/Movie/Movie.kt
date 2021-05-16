package com.example.foodapp.Movie

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Movie (
        @SerializedName("poster_path")
        val posterPath: String? = null,

        val adult: Boolean? = null,

        val overview: String? = null,

        @SerializedName("release_date")
        val releaseDate: String? = null,

        @SerializedName("genre_ids")
        val genreIDS: List<Long>? = null,

        val id: Long? = null,

        @SerializedName("original_title")
        val originalTitle: String? = null,

        @SerializedName("original_language")
        val originalLanguage: OriginalLanguage? = null,

        @SerializedName("title")
        var title: String? = null,

        @SerializedName("backdrop_path")
        val backdropPath: String? = null,

        val popularity: Double? = null,

        @SerializedName("vote_count")
        val voteCount: Long? = null,

        val video: Boolean? = null,

        @SerializedName("vote_average")
        val voteAverage: Double? = null

) : Serializable {
        constructor(name:String): this(){
                title = name
        }
}


enum class OriginalLanguage {
    En,
    Sv
}