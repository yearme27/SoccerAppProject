package com.example.soccerappproject.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soccerappproject.databinding.LeagueListItemBinding
import com.example.soccerappproject.model.LeagueItem
import com.example.soccerappproject.model.LeagueResponse
import com.example.soccerappproject.model.LogosItem
import com.example.soccerappproject.model.SeasonItem
import kotlin.reflect.KFunction1

class SoccerAdapter(
    private val list: MutableList<LeagueItem> = mutableListOf(),
    private val openSeason: (String) -> Unit
//  private val openSeason: (Int, String) -> Unit

): RecyclerView.Adapter<SoccerAdapter.SoccerViewHolder>() {

    fun setLeagueList(newList: List<LeagueItem>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }



    inner class SoccerViewHolder(private val binding: LeagueListItemBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun onBind(item: LeagueItem, ){
                binding.apply {
                    tvListLeague.text = item.name
//                    tvId.text = item.id


                    Glide.with(ivListLeague)
                        .load(item.logos.dark)
                        .into(ivListLeague)
                }

                binding.root.setOnClickListener {
                    openSeason(item.id)
                    println(item.id)
                    // oopenSeeasoon(item2.id, item2.displayName)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoccerViewHolder {
        return SoccerViewHolder(
            LeagueListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SoccerViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}