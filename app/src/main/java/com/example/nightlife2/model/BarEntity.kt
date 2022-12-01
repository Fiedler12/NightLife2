package com.example.nightlife2.model

import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.FtsOptions
import androidx.room.PrimaryKey

@Entity(tableName = "bar")
data class BarEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val rating: Double,
    val description: String
)

@Entity(tableName = "bar_fts")
@Fts4(contentEntity = BarEntity::class)
data class BarFTSEntity(
    val id: Int,
    val name: String
)