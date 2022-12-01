package com.example.nightlife2.API

import com.example.nightlife2.model.BarDto
import com.example.nightlife2.model.ReviewDto
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.Objects

interface BarApi {
     @GET("api/bars/{id}")
     suspend fun getSpecificBar(@Path("id") id: Int): BarDto

     @GET("api/bars")
     suspend fun getBars(): List<BarDto>

     @GET("api/test")
     suspend fun getTest(): String

     @GET("api/review/{id}")
     suspend fun getReviewsForBar(@Path("id") id: Int): List<ReviewDto>

     @GET("api/review")
     suspend fun getAllReviews(): List<ReviewDto>
}