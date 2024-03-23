package com.thecodebasecase.io.repository

import com.thecodebasecase.io.api.ApiService
import javax.inject.Inject

class HouseRepository @Inject constructor(private val apiService: ApiService) : BaseRepository() {

    suspend fun getHouseList() = apiCall {
        apiService.getHouseList()
    }
}
