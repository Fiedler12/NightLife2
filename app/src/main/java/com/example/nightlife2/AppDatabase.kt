package com.example.nightlife2

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nightlife2.DAO.BarDao
import com.example.nightlife2.DatabaseTypeConverters
import com.example.nightlife2.model.BarEntity

@Database(
    entities = [BarEntity::class],
    autoMigrations = [
    ],
    exportSchema = true, version = 1)

@TypeConverters(DatabaseTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun barDao(): BarDao
}