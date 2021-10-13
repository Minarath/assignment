package com.example.assignment.data.beans


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var results: List<Result>? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("total_results")
    var totalResults: Int? = null
)