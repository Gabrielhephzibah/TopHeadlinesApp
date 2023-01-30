package com.example.topheadlinesapp.ui.headline_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.topheadlinesapp.databinding.FragmentHeadlineDetailsBinding
import com.example.topheadlinesapp.di.GlideApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeadlineDetailsFragment : Fragment() {
    private var _binding: FragmentHeadlineDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: HeadlineDetailsFragmentArgs by navArgs()

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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getHeadLineDetails()
        onBackClick()
    }
    private fun getHeadLineDetails() {
        val details = args.headLineItems
        binding.title.text = details?.title
        binding.description.text = details?.description
        binding.content.text = details?.content
        GlideApp.with(binding.root)
            .load(details?.imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(binding.image)
    }
    private fun onBackClick() {
        binding.onBackClick.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}