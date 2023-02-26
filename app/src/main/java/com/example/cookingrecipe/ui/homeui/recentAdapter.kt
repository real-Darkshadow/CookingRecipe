package com.example.cookingrecipe.ui.homeui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R
import com.example.cookingrecipe.apidata.recipes

class recentAdapter(context: Context, reci: recipes, kFunction0: () -> Unit) : RecyclerView.Adapter<recentAdapter.VH>() {
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