package com.example.rickandmortyapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.data.model.Characters
import com.example.rickandmortyapi.databinding.ItemRickAndMortyBinding

class RickAndMortyAdapter(private val onClickListener: (id: Int) -> Unit) :
    ListAdapter<Characters, RickAndMortyAdapter.RickAndMortyViewHolder>(diffUtil) {

    inner class RickAndMortyViewHolder(private val binding: ItemRickAndMortyBinding) :
        ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(adapterPosition).apply { onClickListener(id) }
            }
        }

        fun onBind(item: Characters) {
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
        val diffUtil = object : DiffUtil.ItemCallback<Characters>() {
            override fun areItemsTheSame(oldItem: Characters, newItem: Characters): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Characters, newItem: Characters): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}