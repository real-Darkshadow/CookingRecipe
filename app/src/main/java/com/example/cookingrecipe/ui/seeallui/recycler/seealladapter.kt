package com.example.cookingrecipe.ui.seeallui.recycler

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.ui.homeui.homeDirections
import com.squareup.picasso.Picasso

class seealladapter(val context: Context, val data: recipes, val onsave: () -> Unit): RecyclerView.Adapter<seealladapter.viewhh>(){
    inner class viewhh(View:View): RecyclerView.ViewHolder(View){
        val image=View.findViewById<ImageView>(R.id.tfoodimg)
        val title=View.findViewById<TextView>(R.id.tfoodname)
        val save=View.findViewById<ImageView>(R.id.save)
        val view=View

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewhh {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.seeall,parent,false)
        return viewhh(lay)
    }

    override fun getItemCount(): Int {
        return data.recipes.size
    }

    override fun onBindViewHolder(holder: viewhh, position: Int) {
        holder.title.text=data.recipes[position].title
        Picasso.get().load(data.recipes[position].image).into(holder.image)
        holder.image.setOnClickListener{
            val action= homeDirections.actionHome2ToDetailrecipe2(position,"rec")
            Navigation.findNavController(holder.view).navigate(action)
        }
    }
}