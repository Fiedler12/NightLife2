package com.example.nightlife2.repositories

import com.example.nightlife2.API.ApplicationIoScope
import com.example.nightlife2.API.BarApi
import com.example.nightlife2.DAO.BarDao
import com.example.nightlife2.DAO.ReviewDao
import com.example.nightlife2.model.BarEntity
import com.example.nightlife2.model.ReviewEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReviewRepository @Inject internal constructor(private val barApi: BarApi, private val reviewDao: ReviewDao, @ApplicationIoScope applicationIoScope: CoroutineScope) {

    init {
        applicationIoScope.launch {
            val reviewEntities = barApi.getAllReviews().mapIndexed { index, reviewDto ->
                ReviewEntity(index, reviewDto.barId, reviewDto.review, reviewDto.rating)
            }
            reviewDao.insert(reviewEntities)
        }
    }

    fun getReviewForBar(id: Int): Flow<List<Review>> = reviewDao.getSpecific(id).map { list ->
        list.map {
            Review(it.id, it.barId, it.review, it.rating)
        }
    }
}

data class Review(val id: Int, val barId: Int, val review: String, val rating: Double)