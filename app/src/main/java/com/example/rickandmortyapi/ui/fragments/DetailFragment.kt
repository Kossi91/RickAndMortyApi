package com.example.rickandmortyapi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        viewModel.getSingleCharacter(args.id)
        viewModel.detailLiveData.observe(viewLifecycleOwner) {
            Glide.with(ivImage.context)
                .load(it.image)
                .into(ivImage)
            tvName.text = it.name
            tvGender.text = it.gender
            tvSpecies.text = it.species
            tvStatus.text = it.status
        }
        viewModel.errorDetailLiveData.observe(viewLifecycleOwner){

        }
    }
}