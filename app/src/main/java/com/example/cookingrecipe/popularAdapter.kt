package com.example.cookingrecipe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class popularAdapter(context: Context): RecyclerView.Adapter<popularAdapter.Viewholder>() {
    class Viewholder(view: View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_popularadapter,parent,false)
        return Viewholder(lay)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 7
    }
}