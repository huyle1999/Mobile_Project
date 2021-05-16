package com.example.foodapp.Movie

import com.google.gson.annotations.SerializedName

data class MovieResp (
        val page: Long? = null,
        @SerializedName("results")
        val results: List<Movie>? = null,
        val dates: Dates? = null,

        @SerializedName("total_pages")
        val totalPages: Long? = null,

        @SerializedName("total_results")
        val totalResults: Long? = null
)

data class Dates (
        val maximum: String? = null,
        val minimum: String? = null
)
