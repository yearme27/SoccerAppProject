package com.example.soccerappproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.soccerappproject.databinding.FragmentLeaguesListBinding
import com.example.soccerappproject.databinding.FragmentStartingPageBinding
import com.example.soccerappproject.databinding.LeagueListItemBinding
import com.example.soccerappproject.model.LeagueItem
import com.example.soccerappproject.model.LeagueResponse
import com.example.soccerappproject.model.SeasonItem
import com.example.soccerappproject.model.UIState

class LeagueListFragment: ViewModelFragment(){
    lateinit var binding: FragmentLeaguesListBinding


//    private val soccerAdapter by lazy {
//        SoccerAdapter()
//    }

    private val soccerAdapter by lazy {
        SoccerAdapter(openSeason = ::openSeason)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeaguesListBinding.inflate(layoutInflater)
        configureObserver()
        return binding.root
    }

    private fun configureObserver(){
        viewModel.allLeagueListData.observe(viewLifecycleOwner){ uiState ->
            when (uiState){
                is UIState.Loading -> {
                    viewModel.getDemLeagues(viewModel.startPage)
                }
                is UIState.Error -> {
                    binding.pbLoading.visibility = View.GONE
                    binding.tvLoadingText.text = uiState.error.message
                }
                is UIState.Success<*> -> {
                    binding.apply {
                        rvLeagues.adapter = soccerAdapter
                        pbLoading.visibility = View.GONE
                        tvLoadingText.visibility = View.GONE

                        soccerAdapter.setLeagueList((uiState.response as LeagueResponse).data)
                    }
                }
            }

        }
    }

//    private fun openSeason(leagueItem: LeagueItem){
//        viewModel.setLoadingLeague()
//        findNavController().navigate(
//            LeagueListFragmentDirections.actionLeagueListToSeasonList(
//                leagueItem,
//                ""
//
//            )
//        )
//    }

    fun openSeason(id: String){
        viewModel.setLoadingSeason()
        findNavController().navigate(
            LeagueListFragmentDirections.actionLeagueListToSeasonList(id
            )
        )

    }

}