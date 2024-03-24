package com.thecodebasecase.io.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.thecodebasecase.io.R
import com.thecodebasecase.io.databinding.HouseComponentRowItemBinding
import com.thecodebasecase.io.model.House
import com.thecodebasecase.io.ui.main.adapter.HouseSliderAdapter

class HouseDetailComponent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: HouseComponentRowItemBinding = HouseComponentRowItemBinding.inflate(
        LayoutInflater.from(context), this, true)

    fun setHouseData(house: House, isLastItem: Boolean) {
        binding.location.text = "${house.city} / ${house.district} / ${house.neighborhood}"
        binding.date.text = house.createdDate
        binding.category.text = house.category
        binding.bedrooms.text = "${house.room} oda"
        binding.bathrooms.text = "${house.bathCount} banyo"
        binding.squareMeters.text = "${house.gross} brüt m²"
        binding.squareTwoMeters.text = "${house.net} net m2"
        binding.divider.visibility = if (isLastItem) View.GONE else View.VISIBLE

    }
}