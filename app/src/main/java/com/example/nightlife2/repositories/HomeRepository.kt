package com.example.nightlife2.repositories

import com.example.nightlife2.API.ApplicationIoScope
import com.example.nightlife2.API.BarApi
import com.example.nightlife2.DAO.BarDao
import com.example.nightlife2.model.BarEntity
import com.example.nightlife2.model.BarFTSEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HomeRepository @Inject internal constructor(private val barApi: BarApi, private val barDao: BarDao, @ApplicationIoScope applicationIoScope: CoroutineScope) {

    init {
        applicationIoScope.launch {
            val barEntities = barApi.getBars().mapIndexed { index, barDto ->
                BarEntity(index, barDto.name, barDto.rating, barDto.description)
            }
            barDao.insert(barEntities)
        }
    }

    fun getBars(): Flow<List<Bar>> = flow {
        emit (
            try {
                barApi.getBars().map {
                    Bar(it.id, it.name, it.rating, it.description)
                }
            } catch (e: Exception) {
                println(e)
                emptyList()
            }
        )
    }

    fun getSpecific(id: Int): Flow<Bar> = flow {
        emit(
            try {
                val reqBar = barApi.getSpecificBar(id)
                Bar(reqBar.id, reqBar.name, reqBar.rating, reqBar.description)
            } catch (e: Exception) {
                println(e)
                Bar(id = -1, "Could not load", -1.0, "N/A")
            } as Bar
        )
    }

    fun getBarsFromDb(): Flow<List<Bar>> = barDao.getBars().map { list ->
        list.map {
            Bar(it.id, it.name, it.rating, it.description)
        }
    }

    fun getBarFromDb(id: Int): Flow<Bar> = barDao.getSpecific(id).map {
        Bar(it.id, it.name, it.rating, it.description)
    }
    fun searchForBar(query: String): Flow<List<Bar>> = barDao.getMatchingBars(query).map { list ->
        list.map {
            Bar(it.id, it.name, it.rating, it.description)
        }
    }
}

data class Bar(val id: Int, val name: String, val rating: Double, val description: String)