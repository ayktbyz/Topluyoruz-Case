package com.thecodebasecase.io.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
data class HouseResponse(
    val data: List<House>
)

@Parcelize
data class House(
    val category: String?,
    val city: String?,
    val label: String?,
    val district: String?,
    val neighborhood: String?,
    val currency: String?,
    val roomCount: Int?,
    val bathCount: Int?,
    val price: String?,
    val gross: Int?,
    val net: Int?,
    val room: String?,
    val buildingAge: String?,
    val description: String?,
    val createdDate: String?,
    var images: List<String>
) : Parcelable

