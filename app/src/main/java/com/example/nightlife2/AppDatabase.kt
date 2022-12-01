package com.example.nightlife2

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nightlife2.DAO.BarDao
import com.example.nightlife2.DAO.ReviewDao
import com.example.nightlife2.DatabaseTypeConverters
import com.example.nightlife2.model.BarEntity
import com.example.nightlife2.model.BarFTSEntity
import com.example.nightlife2.model.ReviewEntity

@Database(
    entities = [BarEntity::class, ReviewEntity::class, BarFTSEntity::class],
    autoMigrations = [
    ],
    exportSchema = true, version = 4)

@TypeConverters(DatabaseTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun barDao(): BarDao
    abstract fun reviewDao(): ReviewDao
}