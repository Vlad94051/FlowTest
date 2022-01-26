package com.example.flowtest.data

import com.example.flowtest.data.model.News
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl : NewsRepository {

    override val news: Flow<List<News>> = flow {
        while (true) {
            val news = NewsApi.getNews()
            emit(news)
            delay(5000)
        }
    }


    override fun addNews(news: News) {
        NewsApi.addNews(news)
    }
}