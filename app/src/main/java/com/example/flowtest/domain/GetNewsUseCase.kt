package com.example.flowtest.domain

import com.example.flowtest.data.NewsRepository
import com.example.flowtest.data.getNewsRepository
import com.example.flowtest.domain.model.DomainNews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

fun getNewsUseCase(): GetNewsUseCase = GetNewsUseCaseImpl(
    newsRepository = getNewsRepository()
)

interface GetNewsUseCase {
    val news: Flow<List<DomainNews>>
}

class GetNewsUseCaseImpl(newsRepository: NewsRepository) : GetNewsUseCase {

    override val news: Flow<List<DomainNews>> = newsRepository.news
        .map { news ->
            news.map { item -> DomainNews(item.title) }
        }.flowOn(Dispatchers.IO)

}