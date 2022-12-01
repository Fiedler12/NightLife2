package com.example.nightlife2.API

import android.content.Context
import androidx.room.Room
import com.example.nightlife2.DatabaseTypeConverters
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.nightlife2.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): AppDatabase {
        DatabaseTypeConverters.initialize(moshi)
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "bar.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBarDao(database: AppDatabase) = database.barDao()

    @Singleton
    @Provides
    fun provideReviewDao(database: AppDatabase) = database.reviewDao()
}