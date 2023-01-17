package com.example.rickandmortyapi.data.repositories

import com.example.rickandmortyapi.data.model.Characters
import com.example.rickandmortyapi.data.model.RickAndMortyResponse
import com.example.rickandmortyapi.data.model.detail.CharactersDetail
import com.example.rickandmortyapi.data.remote.api.RickAndMortyApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RickAndMortyRepository(private val rickAndMortyApiService: RickAndMortyApiService) {

    fun getCharacter(
        onSuccess: (rickAndMortyList: List<Characters>) -> Unit,
        onFailure: (message: String) -> Unit,
        page: Int
    ) {
        rickAndMortyApiService.getCharacter(page = page)
            .enqueue(object : Callback<RickAndMortyResponse> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse>,
                    response: Response<RickAndMortyResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            onSuccess(it.results)
                            it.results.clear()
                        }
                    }
                }

                override fun onFailure(call: Call<RickAndMortyResponse>, t: Throwable) {
                    t.localizedMessage?.let {
                        onFailure(it)
                    }
                }
            })
    }

    fun getSingleCharacter(
        onSuccess: (detail: CharactersDetail) -> Unit,
        onFailure: (message: String) -> Unit,
        id: Int
    ) {
        rickAndMortyApiService.getSingleCharacter(id = id)
            .enqueue(object : Callback<CharactersDetail> {
                override fun onResponse(
                    call: Call<CharactersDetail>,
                    response: Response<CharactersDetail>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            onSuccess(it)
                        }
                    }
                }

                override fun onFailure(call: Call<CharactersDetail>, t: Throwable) {
                    t.localizedMessage?.let {
                        onFailure(it)
                    }
                }
            })
    }
}