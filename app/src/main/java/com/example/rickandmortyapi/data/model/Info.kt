package com.example.rickandmortyapi.data.model

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("next")
    val next: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: String?,
    @SerializedName("count")
    val count: Int
)