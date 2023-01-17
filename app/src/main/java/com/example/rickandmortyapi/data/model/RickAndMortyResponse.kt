package com.example.rickandmortyapi.data.model

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(
    @SerializedName("results")
    val results: ArrayList<Characters>,
    @SerializedName("info")
    val info: Info
)
