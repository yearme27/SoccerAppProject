package com.example.soccerappproject.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soccerappproject.databinding.StandingListItemBinding
import com.example.soccerappproject.model.StandingItem

class StandingAdapter(
    private val list: MutableList<StandingItem> = mutableListOf(),
): RecyclerView.Adapter<StandingAdapter.StandingViewHolder>(){

    fun setStandingList(newList: List<StandingItem>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class StandingViewHolder(private val binding: StandingListItemBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun onBind(item: StandingItem){
                binding.apply {
                    tvDraws.text = item.stats[2].value.toString()
                    tvWins.text = item.stats[0].value.toString()
                    tvLoss.text = item.stats[1].value.toString()
                    tvPoints.text = item.stats[4].value.toString()
//                    tvPosition.text = item.note.rank.toString()
                    tvGamesPlayed.text = item.stats[3].value.toString()
                    tvTeamName.text = item.team.shortDisplayName

                    Glide.with(ivTeam)
                        .load(item.team.logos[0].href)
                        .into(ivTeam)
                }
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingViewHolder {
        return StandingViewHolder(
            StandingListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StandingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}