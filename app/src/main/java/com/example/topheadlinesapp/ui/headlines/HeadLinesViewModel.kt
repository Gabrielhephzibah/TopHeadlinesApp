package com.example.topheadlinesapp.ui.headlines

import androidx.lifecycle.ViewModel
import com.example.topheadlinesapp.data.repository.TopHeadlineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeadLinesViewModel @Inject constructor(private val repository: TopHeadlineRepository) : ViewModel(){
   fun getTopHeadlines() = repository.getTopHeadlines()

}