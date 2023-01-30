package com.example.topheadlinesapp.data.remote

import com.example.topheadlinesapp.data.model.remote.TopHeadlineResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlineAPI {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): TopHeadlineResponse
}