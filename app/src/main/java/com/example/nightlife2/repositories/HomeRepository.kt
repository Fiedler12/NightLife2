package com.example.nightlife2.repositories

import com.example.nightlife2.API.BarApi
import com.example.nightlife2.model.Bar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository @Inject internal constructor(private val barApi: BarApi) {

    fun getBars(): Flow<List<Bar>> = flow {
        emit (
            try {
                barApi.getBars().map {
                    Bar(it.id, it.name, it.rating)
                }
            } catch (e: Exception) {
                println(e.stackTrace)
                emptyList()
            }
        )
    }
}