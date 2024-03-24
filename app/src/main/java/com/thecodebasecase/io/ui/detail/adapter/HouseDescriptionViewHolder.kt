package com.thecodebasecase.io.ui.detail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.thecodebasecase.io.databinding.HouseDescriptionRowItemBinding
import com.thecodebasecase.io.model.House

class HouseDescriptionViewHolder(
    private val binding: HouseDescriptionRowItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: House) {
        binding.apply {
         binding.description.text = data.description
        }
    }
}