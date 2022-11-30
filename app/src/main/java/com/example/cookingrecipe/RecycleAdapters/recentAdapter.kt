package com.example.cookingrecipe.RecycleAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R

class recentAdapter(context: Context) : RecyclerView.Adapter<recentAdapter.VH>() {
    class VH(ciew: View) : RecyclerView.ViewHolder(ciew) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_recentrecycler,parent,false)
        return VH(lay)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

    }

    override fun getItemCount(): Int {
        return 8
    }
}