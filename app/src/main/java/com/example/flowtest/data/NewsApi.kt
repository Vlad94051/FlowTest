package com.example.flowtest.data

import com.example.flowtest.data.model.News

object NewsApi {

    private var localNews = mutableListOf(
        News(title = "title1"),
        News(title = "title2"),
        News(title = "title3")
    )

     fun getNews(): List<News> {
        return localNews
    }

     fun addNews(news: News) {
        localNews.add(news)
    }

}