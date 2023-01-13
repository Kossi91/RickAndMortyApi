package com.example.rickandmortyapi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelStore
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentRickAndMortyBinding
import com.example.rickandmortyapi.ui.adapters.RickAndMortyAdapter
import okhttp3.internal.EMPTY_REQUEST

class RickAndMortyFragment : Fragment() {

    private lateinit var binding: FragmentRickAndMortyBinding
    private val viewModel by viewModels<RickAndMortyViewModel>()
    private val rickAndMortyAdapter = RickAndMortyAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRickAndMortyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding.rvRickAndMorty.adapter = rickAndMortyAdapter
    }

    private fun setupObserve() {
       viewModel.rickAndMortyLiveData.observe(viewLifecycleOwner){
          rickAndMortyAdapter.submitList(it)
       }
    }
}