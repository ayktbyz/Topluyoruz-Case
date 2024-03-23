package com.thecodebasecase.io.model
data class HouseResponse(
    val data: List<House>
)

data class House(
    val category: String,
    val city: String,
    val label: String?,
    val district: String,
    val neighborhood: String,
    val currency: String,
    val roomCount: Int,
    val bathCount: Int,
    val price: String,
    val gross: Int,
    val net: Int,
    val room: String,
    val buildingAge: String,
    val description: String,
    val createdDate: String,
    val images: List<String>
)
