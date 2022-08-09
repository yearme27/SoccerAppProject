package com.example.soccerappproject.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerappproject.databinding.SeasonListItemBinding
import com.example.soccerappproject.model.SeasonItem

class SeasonAdapter (
    private val list: MutableList<SeasonItem> = mutableListOf(),
    private val openStanding: (Int) -> Unit
): RecyclerView.Adapter<SeasonAdapter.SeasonViewHolder>(){

    fun setSeasonList(newList: List<SeasonItem>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class SeasonViewHolder(private val binding: SeasonListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
            fun onBind(item: SeasonItem){
                binding.apply {
                    tvLeague.text = item.displayName
                    tvYear.text = item.year.toString()
                }

                binding.root.setOnClickListener {
                    openStanding(item.year)
                }

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        return SeasonViewHolder(
            SeasonListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}