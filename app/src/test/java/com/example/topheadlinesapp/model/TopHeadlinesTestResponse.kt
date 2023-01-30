package com.example.topheadlinesapp.model

import com.example.topheadlinesapp.data.model.remote.Article
import com.example.topheadlinesapp.data.model.remote.Source
import com.example.topheadlinesapp.data.model.remote.TopHeadlineResponse

object TopHeadlinesTestResponse {
    val response = TopHeadlineResponse(listOf(
        Article("author",
            "content",
            "description,",
        "publishedAt",
        Source("id", "name"),
            "title",
            "url",
            "urlToImage"
        )),
    "Success",
    10)
}