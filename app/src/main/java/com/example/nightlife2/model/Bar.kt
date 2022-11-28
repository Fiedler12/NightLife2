package com.example.nightlife2.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BarDto (
    val id: Int,
    val name: String,
    val rating: Double
)