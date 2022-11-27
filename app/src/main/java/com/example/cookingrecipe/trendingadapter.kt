package com.example.cookingrecipe

import android.content.Context
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class trendingadapter(val context: Context): RecyclerView.Adapter<trendingadapter.viewholder>() {

    class viewholder(view: View):RecyclerView.ViewHolder(view){
        val image=view.findViewById<ImageView>(R.id.tfoodimg)
        val text=view.findViewById<TextView>(R.id.tfoodname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_trendingadapter,parent,false)
        return viewholder(lay)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 7
    }
}