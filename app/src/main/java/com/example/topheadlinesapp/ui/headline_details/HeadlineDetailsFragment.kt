package com.example.topheadlinesapp.ui.headline_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.topheadlinesapp.databinding.FragmentHeadlineDetailsBinding


class HeadlineDetailsFragment : Fragment() {
    private var _binding: FragmentHeadlineDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHeadlineDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }



}