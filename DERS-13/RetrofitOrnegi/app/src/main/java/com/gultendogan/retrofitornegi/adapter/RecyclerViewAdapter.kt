package com.gultendogan.retrofitornegi.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gultendogan.retrofitornegi.MainActivity
import com.gultendogan.retrofitornegi.databinding.RowLayoutBinding
import com.gultendogan.retrofitornegi.model.PokemonModel

class RecyclerViewAdapter(private val pokemonList: ArrayList<PokemonModel>, private val listener: MainActivity) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    class RowHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClick(pokemonList.get(position))
        }

        val type = pokemonList.get(position).type
        when(type){
            "Grass" -> {
                holder.itemView.setBackgroundColor(Color.parseColor("#4CBB17"))
            }
            "Fire" -> {
                holder.itemView.setBackgroundColor(Color.parseColor("#FF2400"))
            }
            "Water" -> {
                holder.itemView.setBackgroundColor(Color.parseColor("#6495ED"))
            }
            "Bug" -> {
                holder.itemView.setBackgroundColor(Color.parseColor("#00A36C"))
            }
            "Normal" ->{
                holder.itemView.setBackgroundColor(Color.parseColor("#808080"))
            }
            "Poison" ->{
                holder.itemView.setBackgroundColor(Color.parseColor("#BF40BF"))
            }
            "Electric" ->{
                holder.itemView.setBackgroundColor(Color.parseColor("#FFD700"))
            }
            "Ground" ->{
                holder.itemView.setBackgroundColor(Color.parseColor("#FFC000"))
            }
        }

        holder.binding.textId.text = pokemonList.get(position).id
        holder.binding.textName.text = "Name : ${pokemonList.get(position).name}"
        holder.binding.textType.text = "Type : ${pokemonList.get(position).type}"
        holder.binding.textHeight.text = "Height : ${pokemonList.get(position).height}"
        holder.binding.textWeight.text = "Weight : ${pokemonList.get(position).weight}"
        holder.binding.textCategory.text = "Category : ${pokemonList.get(position).category}"
        holder.binding.textAbilities.text = "Abilities : ${pokemonList.get(position).abilities}"



    }


}