package com.example.cookingrecipe.RecycleAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R

class savedAdapter(context: Context): RecyclerView.Adapter<savedAdapter.viewholder>() {
    class viewholder(view: View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_savedrecycler,parent,false)
        return viewholder(lay)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 16
    }
}