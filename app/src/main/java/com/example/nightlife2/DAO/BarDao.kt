package com.example.nightlife2.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nightlife2.model.BarEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BarDao {
    @Insert
    suspend fun insert(bar: BarEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(bars: List<BarEntity>)

    @Delete
    suspend fun delete(bar: BarEntity)

    @Query("SELECT * FROM bar")
    fun getBars(): Flow<List<BarEntity>>

    @Query("SELECT * FROM bar where id = :id")
    fun getSpecific(id: Int): Flow<BarEntity>

    @Query("SELECT * FROM bar JOIN bar_fts ON bar.id = bar_fts.id WHERE bar_fts.name MATCH :query")
    fun getMatchingBars(query: String): Flow<List<BarEntity>>
}