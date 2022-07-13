package com.gultendogan.narutorecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gultendogan.narutorecyclerview.databinding.RecyclerRowBinding

class NarutoAdapter(val narutoList : ArrayList<Naruto>) : RecyclerView.Adapter<NarutoAdapter.NarutoHolder>() {

    class NarutoHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NarutoHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NarutoHolder(binding)
    }

    override fun onBindViewHolder(holder: NarutoHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = narutoList.get(position).name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("naruto",narutoList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return narutoList.size
    }


}