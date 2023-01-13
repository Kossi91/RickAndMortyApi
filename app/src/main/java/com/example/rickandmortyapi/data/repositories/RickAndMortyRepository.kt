package com.example.rickandmortyapi.data.repositories

import com.example.rickandmortyapi.data.model.RickAndMorty
import com.example.rickandmortyapi.data.model.RickAndMortyResponse
import com.example.rickandmortyapi.data.remote.api.RickAndMortyApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RickAndMortyRepository(private val rickAndMortyApiService: RickAndMortyApiService) {

    fun getCharacter(
        onSuccess:(rickAndMortyList: List<RickAndMorty>) -> Unit,
        onFailure:(message: String)->Unit,
    ){
        rickAndMortyApiService.getCharacter().enqueue(object : Callback<RickAndMortyResponse> {
            override fun onResponse(
                call: Call<RickAndMortyResponse>,
                response: Response<RickAndMortyResponse>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        onSuccess(it.results)
                    }
                }
            }

            override fun onFailure(call: Call<RickAndMortyResponse>, t: Throwable) {
                t.localizedMessage?.let {
                    onFailure(it) }
            }
        })
    }
}