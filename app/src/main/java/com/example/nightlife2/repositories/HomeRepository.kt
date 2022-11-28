package com.example.nightlife2.repositories

import com.example.nightlife2.API.BarApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject internal constructor(private val barApi: BarApi) {

    fun getBars(): Flow<List<Bar>> = flow {
        emit (
            try {
                barApi.getBars().map {
                    Bar(it.id, it.name, it.rating)
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
                Bar(reqBar.id, reqBar.name, reqBar.rating)
            } catch (e: Exception) {
                println(e)
                Bar(id = -1, "Could not load", -1.0)
            } as Bar
        )
    }
}

data class Bar(val id: Int, val name: String, val rating: Double)