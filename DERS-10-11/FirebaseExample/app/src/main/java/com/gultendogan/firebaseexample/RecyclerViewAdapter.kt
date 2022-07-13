package com.gultendogan.firebaseexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerViewAdapter(val shareList : ArrayList<Share>) : RecyclerView.Adapter<RecyclerViewAdapter.ShareHolder>() {

    class ShareHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShareHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row,parent,false)
        return ShareHolder(view)
    }

    override fun onBindViewHolder(holder: ShareHolder, position: Int) {
        holder.itemView.recycler_row_user_name.text = shareList[position].userName
        holder.itemView.recycler_row_share_commend.text = shareList[position].userComment
        if(shareList[position].imageUrl != null){
            holder.itemView.recycler_row_image.visibility = View.VISIBLE
            Picasso.get().load(shareList[position].imageUrl).into(holder.itemView.recycler_row_image)
        }
    }

    override fun getItemCount(): Int {
        return shareList.size
    }
}