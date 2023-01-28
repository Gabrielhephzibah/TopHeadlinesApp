package com.example.topheadlinesapp.ui.headlines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.topheadlinesapp.data.model.local.HeadLinesItem
import com.example.topheadlinesapp.data.model.remote.TopHeadlineResponse
import com.example.topheadlinesapp.databinding.FragmentHeadlinesBinding
import com.example.topheadlinesapp.utils.Resource
import com.example.topheadlinesapp.utils.extensions.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeadLinesFragment : Fragment() {
    private var _binding: FragmentHeadlinesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HeadLinesViewModel by viewModels()
    private var adapter: HeadLinesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHeadlinesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        getTopHeadLines()
        retry()
    }
    
    private fun getTopHeadLines() {
        viewLifecycleOwner.collect(
            flow = viewModel.getTopHeadlines(),
            action = ::setTopHeadLines
        )
    }
    private fun setUpAdapter() {
        adapter = HeadLinesAdapter {
            findNavController().navigate(
                HeadLinesFragmentDirections.actionHeadlinesFragmentToHeadlineDetailsFragment(it)
            )
        }
        binding.recyclerView.adapter = adapter
    }
    private fun setTopHeadLines(response: Resource<TopHeadlineResponse?>) {
        if (response is Resource.Error)
            error(binding.recyclerView, binding.progressBar, binding.error,binding.btnRetry)
        else
            success(binding.recyclerView, binding.progressBar, binding.error, binding.btnRetry)
        val item = response.data?.articles?.map { headline ->
            HeadLinesItem(
                headline.title,
                headline.publishedAt,
                headline.description,
                headline.content,
                headline.urlToImage,
                headline.publishedAt
            )
        }
        adapter?.submitList(item?.sortedByDescending { it.publishedAt })
    }
    private fun retry(){
        binding.btnRetry.setOnClickListener{
            getTopHeadLines()
            loading(binding.recyclerView, binding.progressBar, binding.error, binding.btnRetry)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}