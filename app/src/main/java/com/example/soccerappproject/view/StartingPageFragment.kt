package com.example.soccerappproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.soccerappproject.databinding.FragmentStartingPageBinding

class StartingPageFragment: ViewModelFragment() {
    lateinit var binding: FragmentStartingPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartingPageBinding.inflate(layoutInflater)

        binding.btnListLeague.setOnClickListener {
            viewModel.shouldLoadId = false
            viewModel.setLoading()
            findNavController().navigate(
                StartingPageFragmentDirections.actionStartingPageToLeagueList())
        }

        binding.btnLeagueAbbr.setOnClickListener {
            viewModel.shouldLoadId = true
            viewModel.setLoading()
            findNavController().navigate(
                StartingPageFragmentDirections.actionSeasonList(
                    binding.etAbbrInput.text.toString()
                )
            )
        }

        return binding.root
    }


}