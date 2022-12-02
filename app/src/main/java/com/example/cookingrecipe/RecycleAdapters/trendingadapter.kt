package com.example.cookingrecipe.RecycleAdapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R
import com.example.cookingrecipe.apidata.recipes
import com.squareup.picasso.Picasso

class trendingadapter(val context: Context,val rec:recipes): RecyclerView.Adapter<trendingadapter.viewholder>() {

    class viewholder(view: View):RecyclerView.ViewHolder(view){
        val image=view.findViewById<ImageView>(R.id.tfoodimg)
        val text=view.findViewById<TextView>(R.id.tfoodname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_trendingadapter,parent,false)
        return viewholder(lay)
    }
    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.text.text=rec.recipes[position].title
        Picasso.get().load(rec.recipes[position].image).noFade().into(holder.image)
        holder.image.setOnClickListener{
            val intent=Intent()
        }
    }

    override fun getItemCount(): Int {
        return rec.recipes.size-15
    }
}