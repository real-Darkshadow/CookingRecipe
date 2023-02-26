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

class trendingadapter(val context: Context, val rec: recipes, kFunction0: () -> Unit): RecyclerView.Adapter<trendingadapter.viewholder>() {

    class viewholder(view: View):RecyclerView.ViewHolder(view){
        val image=view.findViewById<ImageView>(R.id.tfoodimg)
        val text=view.findViewById<TextView>(R.id.tfoodname)
        val view=view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_trendingadapter,parent,false)
        return viewholder(lay)
    }
    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.text.text=rec.recipes[position].title
        Picasso.get().load(rec.recipes[position].image).noFade().into(holder.image)
        holder.image.setOnClickListener{
            val action=homeDirections.actionHome2ToDetailrecipe2(rec.recipes[position].title,rec.recipes[position].image,position)
            Navigation.findNavController(holder.view).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return rec.recipes.size-15
    }
}