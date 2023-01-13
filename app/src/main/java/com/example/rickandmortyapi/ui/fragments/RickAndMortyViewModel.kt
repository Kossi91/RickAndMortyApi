package com.example.rickandmortyapi.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.data.model.RickAndMorty
import com.example.rickandmortyapi.data.repositories.RickAndMortyRepository

class RickAndMortyViewModel : ViewModel() {

    private val repository = RickAndMortyRepository(App.retrofitClient.rickAndMortyApiService)

    private val _rickAndMortyLiveData = MutableLiveData<List<RickAndMorty>>()
    val rickAndMortyLiveData: LiveData<List<RickAndMorty>> = _rickAndMortyLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData:LiveData<String> = _errorLiveData

    init {
        getCharacter()
    }

    fun getCharacter() {
        repository.getCharacter(
            onSuccess = {
                _rickAndMortyLiveData.value = it
            },
            onFailure = {
                _errorLiveData.value = it
            }
        )
    }
}