package com.example.flowtest.domain

import com.example.flowtest.data.NewsRepository
import com.example.flowtest.data.getNewsRepository
import com.example.flowtest.data.model.News
import com.example.flowtest.domain.model.DomainNews

fun getAddNewsUseCase(): AddNewsUseCase = AddNewsUseCaseImpl(
    newsRepository = getNewsRepository()
)

interface AddNewsUseCase {
    fun addNews(news: DomainNews)
}

class AddNewsUseCaseImpl(private val newsRepository: NewsRepository) : AddNewsUseCase {
    override fun addNews(news: DomainNews) {
        newsRepository.addNews(News(title = news.title))
    }

}