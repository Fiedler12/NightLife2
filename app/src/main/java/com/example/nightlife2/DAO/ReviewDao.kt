package com.example.nightlife2.DAO

import androidx.room.*
import com.example.nightlife2.model.BarEntity
import com.example.nightlife2.model.ReviewDto
import com.example.nightlife2.model.ReviewEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewDao {
    @Insert
    suspend fun insert(review: ReviewEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(reviews: List<ReviewEntity>)

    @Delete
    suspend fun delete(review: ReviewEntity)

    @Query("SELECT * FROM review where barId = :id")
    fun getSpecific(id:Int): Flow<List<ReviewEntity>>

    @Query("SELECT * FROM review")
    fun getReviews(): Flow<ReviewEntity>
}