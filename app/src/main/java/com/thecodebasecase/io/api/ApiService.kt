package com.thecodebasecase.io.api

import com.thecodebasecase.io.model.HouseResponse
import retrofit2.Response
import retrofit2.http.GET
interface ApiService {
    @GET("ofarukcelik/master/android-test-case.json")
    suspend fun getHouseList(): Response<HouseResponse>
}