package com.example.rickandmortyapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.data.model.RickAndMorty
import com.example.rickandmortyapi.databinding.ItemRickAndMortyBinding

class RickAndMortyAdapter :
    ListAdapter<RickAndMorty, RickAndMortyAdapter.RickAndMortyViewHolder>(diffUtil) {

    inner class RickAndMortyViewHolder(val binding: ItemRickAndMortyBinding) :
        ViewHolder(binding.root) {
        fun onBind(item: RickAndMorty) {
            Glide.with(binding.imageIcon.context)
                .load(item.image)
                .into(binding.imageIcon)
            binding.namePerson.text = item.name.replaceFirstChar {
                it.uppercase()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder {
        return RickAndMortyViewHolder(
            ItemRickAndMortyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RickAndMortyViewHolder, position: Int) {
        getItem(position).let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RickAndMorty>() {
            override fun areItemsTheSame(oldItem: RickAndMorty, newItem: RickAndMorty): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: RickAndMorty, newItem: RickAndMorty): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}