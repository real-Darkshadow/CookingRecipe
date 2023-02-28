package com.example.cookingrecipe.ui.homeui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R
import com.example.cookingrecipe.apidata.recipes
import com.squareup.picasso.Picasso
import kotlin.reflect.KFunction3

class recentAdapter(val context: Context, val rec: recipes, val kFunction0: KFunction3<String, String, String, Unit>) : RecyclerView.Adapter<recentAdapter.VH>() {
    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val image=view.findViewById<ImageView>(R.id.image2)
        val name=view.findViewById<TextView>(R.id.tffodname)
        val view=view

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_recentrecycler,parent,false)
        return VH(lay)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        Picasso.get().load(rec.recipes[position+10].image).into(holder.image)
        holder.name.text=rec.recipes[position+10].title
        holder.image.setOnClickListener{
            val action=homeDirections.actionHome2ToDetailrecipe2(position+10,"rec")
            Navigation.findNavController(holder.view).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return rec.recipes.size-15
    }
}