package com.example.islam360_api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.islam360_api.databinding.ItemLayoutBinding

class MyAdapter(val context: Context, val surahlist: List<Post>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val surah_list = surahlist[position]
        holder.dataBinding(surah_list)

//        holder.Language.text = surah_list.language
//        holder.tags.text = surah_list.tags
//        Glide.with(context)
//            .load("https://islam360.app/islam360/posts/image/urdu/" + surah_list.path)
//            .into(holder.surahPath)

    }

    override fun getItemCount(): Int {
        return surahlist.size
    }

    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun dataBinding(Mypost:Post) {
            binding.myData = Mypost
        }

//        var Language = binding.language
//        var tags = binding.Tags
//        var surahPath = binding.surahImage
    }

}

@BindingAdapter("imageFromUrl")
fun ImageView.imageFromUrl(url:String)
{
    val baseUrl = "https://islam360.app/islam360/posts/image/urdu/"
    Glide.with(this.context).load(baseUrl+url).into(this)

}