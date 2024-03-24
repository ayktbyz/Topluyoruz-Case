package com.thecodebasecase.io.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thecodebasecase.io.databinding.HouseDescriptionRowItemBinding
import com.thecodebasecase.io.databinding.HouseDetailRowItemBinding
import com.thecodebasecase.io.databinding.HouseFeaturesRowItemBinding
import com.thecodebasecase.io.model.House
import com.thecodebasecase.io.other.Constants

class HouseDetailAdapter(private val house: House) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> Constants.HouseDetailType.VIEW_TYPE_DETAIL
            1 -> Constants.HouseDetailType.VIEW_TYPE_FEATURES
            else -> Constants.HouseDetailType.VIEW_TYPE_DESCRIPTION
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Constants.HouseDetailType.VIEW_TYPE_DESCRIPTION -> {
                return HouseDescriptionViewHolder(
                    HouseDescriptionRowItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            Constants.HouseDetailType.VIEW_TYPE_FEATURES -> {
                return HouseFeaturesViewHolder(
                    HouseFeaturesRowItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            Constants.HouseDetailType.VIEW_TYPE_DETAIL -> {
                return HouseDetailViewHolder(
                    HouseDetailRowItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HouseDescriptionViewHolder -> {
                holder.bind(house)
            }
            is HouseFeaturesViewHolder -> {
                holder.bind(house)
            }
            is HouseDetailViewHolder -> {
                holder.bind(house)
            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}
