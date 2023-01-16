package com.example.rickandmortyapi

import android.app.Application
import com.example.rickandmortyapi.data.remote.RetrofitClient

class App: Application() {

    companion object{
      val retrofitClient = RetrofitClient()
    }
}