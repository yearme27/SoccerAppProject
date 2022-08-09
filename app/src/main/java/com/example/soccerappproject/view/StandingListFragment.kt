package com.example.soccerappproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.soccerappproject.databinding.FragmentStandingListBinding
import com.example.soccerappproject.databinding.StandingListItemBinding
import com.example.soccerappproject.model.StandingResponse
import com.example.soccerappproject.model.UIState

class StandingListFragment: ViewModelFragment() {

    lateinit var binding: FragmentStandingListBinding

    private val standingAdapter by lazy {
       StandingAdapter()
    }

    private val args: StandingListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStandingListBinding.inflate(layoutInflater)
        configureObserver()
        return binding.root
    }

    private fun configureObserver(){
        viewModel.allStandingListData.observe(viewLifecycleOwner){ uistate ->
            when(uistate){
                is UIState.Loading -> {
                    viewModel.getDemStanding(args.seasonYear, args.leagueId)
                }
                is UIState.Error -> {
                    binding.apply {
                        pbLoadStanding.visibility = View.GONE
                        tvErrorTextStanding.text = uistate.error.message
                    }
                }
                is UIState.Success<*> ->{
                    binding.apply {
                        standingAdapter.setStandingList((uistate.response as StandingResponse).data.standings)
                        rvStanding.adapter = standingAdapter
                        pbLoadStanding.visibility = View.GONE
                    }
                }
            }
        }
    }

}