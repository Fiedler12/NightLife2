package com.example.nightlife2.API

import com.example.nightlife2.model.BarDto
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.Objects

interface BarApi {
     @GET("api/bar/{id}")
     suspend fun getSpecificBar(@Path("id") id: Int): BarDto

     @GET("api/bars")
     suspend fun getBars(): List<BarDto>

     @GET("api/test")
     suspend fun getTest(): String
}