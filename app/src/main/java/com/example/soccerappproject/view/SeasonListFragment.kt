package com.example.soccerappproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.soccerappproject.databinding.FragmentSeasonListBinding
import com.example.soccerappproject.model.LeagueDetails
import com.example.soccerappproject.model.SeasonItem
import com.example.soccerappproject.model.SeasonResponse
import com.example.soccerappproject.model.UIState

class SeasonListFragment: ViewModelFragment() {
    lateinit var binding: FragmentSeasonListBinding

    private val seasonAdapter by lazy {
        SeasonAdapter(openStanding = ::openStanding)
    }

    private val args: SeasonListFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeasonListBinding.inflate(layoutInflater)
        configureObserver()
        return binding.root
    }

    private fun configureObserver(){
        viewModel.allSeasonListData.observe(viewLifecycleOwner) { uistate ->
            when (uistate){
                is UIState.Loading -> {
                    viewModel.getDemSeason(args.leagueId)
                }
                is UIState.Error -> {
                    binding.apply {
                        pbLoadById.visibility = View.GONE
                        tvErrorTextSeason.text = uistate.error.message
                    }
                }
                is UIState.Success<*> -> {
                    binding.apply {
                        seasonAdapter.setSeasonList((uistate.response as SeasonResponse).data.seasons)
                        rvSeason.adapter = seasonAdapter
                        pbLoadById.visibility = View.GONE


                    }
                }
            }
        }
    }

    fun openStanding(season: Int){
        viewModel.setLoadingStanding()
        findNavController().navigate(
            SeasonListFragmentDirections.actionSeasonListToStanding(args.leagueId,season)
        )
    }


}