package com.example.nightlife2.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Review(
    val id: Int,
    val barId: Int,
    val review: String,
    val rating: Double
)