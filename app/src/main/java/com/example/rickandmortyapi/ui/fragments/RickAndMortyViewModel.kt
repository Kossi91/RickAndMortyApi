package com.example.rickandmortyapi.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.data.model.Characters
import com.example.rickandmortyapi.data.repositories.RickAndMortyRepository

class RickAndMortyViewModel : ViewModel() {

    private val repository = RickAndMortyRepository(App.retrofitClient.rickAndMortyApiService)

        private val _rickAndMortyLiveData = MutableLiveData<List<Characters>>()
        val rickAndMortyLiveData: LiveData<List<Characters>> = _rickAndMortyLiveData

        private val _errorLiveData = MutableLiveData<String>()
        val errorLiveData:LiveData<String> = _errorLiveData

    init {
        getCharacter(page = 1)
    }

        fun getCharacter(page: Int) {
            repository.getCharacter(
            onSuccess = {
                _rickAndMortyLiveData.value = it
            },
            onFailure = {
                _errorLiveData.value = it
            },
            page = page
        )
    }
}