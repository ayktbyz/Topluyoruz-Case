package com.thecodebasecase.io.ui.detail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.thecodebasecase.io.databinding.HouseDetailRowItemBinding
import com.thecodebasecase.io.model.House

class HouseDetailViewHolder(
    private val binding: HouseDetailRowItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: House) {
        binding.apply {
            binding.houseDetailComponent.setHouseData(data, false)
        }
    }
}