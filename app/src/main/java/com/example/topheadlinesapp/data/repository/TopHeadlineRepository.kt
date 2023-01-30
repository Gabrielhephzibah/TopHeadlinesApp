package com.example.topheadlinesapp.data.repository

import com.example.topheadlinesapp.BuildConfig
import com.example.topheadlinesapp.data.model.remote.TopHeadlineResponse
import com.example.topheadlinesapp.data.remote.TopHeadlineAPI
import com.example.topheadlinesapp.utils.AppConstant.NEWS_SOURCE
import com.example.topheadlinesapp.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TopHeadlineRepository @Inject constructor(
    private val topHeadlineAPI: TopHeadlineAPI,
    private val ioDispatcher: CoroutineDispatcher
) {
    fun getTopHeadlines(): Flow<Resource<TopHeadlineResponse?>> =
        flow<Resource<TopHeadlineResponse?>> {
            val response = topHeadlineAPI.getTopHeadlines(
                NEWS_SOURCE,
                BuildConfig.API_KEY
            )
            emit(Resource.Success(response))
        }.flowOn(ioDispatcher)
            .catch {
                emit(Resource.Error(it))
            }
}