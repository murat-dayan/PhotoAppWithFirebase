package com.example.benimfotouyg

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_row.view.*

class PostsRecyclerAdapter(val postList:ArrayList<Post>):RecyclerView.Adapter<PostsRecyclerAdapter.PostHolder>() {

    class PostHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val baglayici = LayoutInflater.from(parent.context)
        val view = baglayici.inflate(R.layout.recycler_row , parent , false)
        return PostHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.itemView.recycler_row_kullanici_text.text = postList[position].kEmail
        holder.itemView.recycler_row_yorum_text.text = postList[position].kYorum
        Picasso.get().load(postList[position].gUrl).into(holder.itemView.recycler_row_imageview)
    }
}