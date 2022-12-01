package com.example.nightlife2.model

import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

@Entity(tableName = "review")
data class ReviewEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val barId: Int,
    val review: String,
    val rating: Double
    )

