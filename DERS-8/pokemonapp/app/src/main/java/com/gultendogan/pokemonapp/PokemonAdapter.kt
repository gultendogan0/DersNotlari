package com.gultendogan.pokemonapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gultendogan.pokemonapp.databinding.RecyclerRowBinding

class PokemonAdapter(val pokeList: ArrayList<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.PokemonHolder>() {

    class PokemonHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PokemonHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = pokeList.get(position).name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,PokeActivity::class.java)
            intent.putExtra("info","old")
            intent.putExtra("id",pokeList.get(position).id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return pokeList.size
    }
}