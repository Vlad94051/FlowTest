package com.example.flowtest.data

import com.example.flowtest.data.model.News
import kotlinx.coroutines.flow.Flow

fun getNewsRepository(): NewsRepository = NewsRepositoryImpl()

interface NewsRepository {
    val news: Flow<List<News>>

    fun addNews(news: News)
}