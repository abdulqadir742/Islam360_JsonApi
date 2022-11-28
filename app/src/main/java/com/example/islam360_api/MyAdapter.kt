package com.example.islam360_api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.islam360_api.databinding.ItemLayoutBinding

class MyAdapter(val context: Context,val surahlist: List<Post>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load("https://islam360.app/islam360/posts/image/urdu/"+surahlist[position].path).into(holder.surahPath)
    }

    override fun getItemCount(): Int {
        return surahlist.size
    }

    class ViewHolder(binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root ){
        var surahPath:ImageView = binding.surahImage
    }
}