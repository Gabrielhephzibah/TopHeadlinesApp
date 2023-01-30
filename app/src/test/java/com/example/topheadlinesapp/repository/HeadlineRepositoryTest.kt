package com.example.topheadlinesapp.repository

import app.cash.turbine.test
import com.example.topheadlinesapp.data.remote.TopHeadlineAPI
import com.example.topheadlinesapp.data.repository.TopHeadlineRepository
import com.example.topheadlinesapp.model.TopHeadlinesTestResponse
import com.example.topheadlinesapp.utils.MainDispatcherRule
import com.example.topheadlinesapp.utils.Resource
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.given
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class HeadlineRepositoryTest {
    private lateinit var topHeadlineRepository: TopHeadlineRepository

    private val topHeadlineAPI = mock<TopHeadlineAPI>()

    private val dispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setUp() {
        topHeadlineRepository = TopHeadlineRepository(topHeadlineAPI, dispatcher)
    }

    @Test
    fun `test getTopHeadLines_onSuccess`() = runTest {
        given(
            topHeadlineAPI.getTopHeadlines(
                any(),
                any(),
            )
        ).willReturn(TopHeadlinesTestResponse.response)

        topHeadlineRepository.getTopHeadlines().test {
            assertThat(Resource.Success(TopHeadlinesTestResponse.response)).isEqualTo(awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test(expected = Throwable::class)
    fun `test getTopHeadLines_onError`() = runTest {
        given(
            topHeadlineAPI.getTopHeadlines(
                any(),
                any(),
            )
        ).willThrow(Throwable())

        topHeadlineRepository.getTopHeadlines().test  {
            assertThat(Resource.Error(Throwable())).isEqualTo(awaitItem())
            cancelAndIgnoreRemainingEvents()
        }

    }

}