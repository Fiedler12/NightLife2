package com.example.nightlife2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bar")
data class BarEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val rating: Double,
    val description: String
)