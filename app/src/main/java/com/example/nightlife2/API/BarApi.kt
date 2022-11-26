package com.example.nightlife2.API

import com.example.nightlife2.model.Bar
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.Objects

interface BarApi {
     @GET("/api/bar/{ad}")
     suspend fun getSpecificBar(@Path("id") id: Int): Bar

     @GET("/api/bars")
     suspend fun getBars(): List<Bar>

     @GET("/api/test")
     suspend fun getTest(): String
}