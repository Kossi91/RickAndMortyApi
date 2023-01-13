package com.example.rickandmortyapi.data.remote.api

import com.example.rickandmortyapi.data.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApiService {

    @GET("character")
    fun getCharacter() : Call<RickAndMortyResponse>
}