package com.example.cookingrecipe.ui.homeui

import android.annotation.SuppressLint
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

class popularAdapter(context: Context, val rec: recipes,val onsave: () -> Unit): RecyclerView.Adapter<popularAdapter.Viewholder>() {
    class Viewholder(view: View):RecyclerView.ViewHolder(view){
        val text=view.findViewById<TextView>(R.id.ptext)
        val image=view.findViewById<ImageView>(R.id.pimage)
        val time=view.findViewById<TextView>(R.id.tfoodmin)
        val view=view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_popularadapter,parent,false)
        return Viewholder(lay)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.text.text=rec.recipes[position].title
        Picasso.get().load(rec.recipes[position].image).into(holder.image)
        holder.time.text="${rec.recipes[position].readyInMinutes} mins"
        holder.image.setOnClickListener{
            val action=homeDirections.actionHome2ToDetailrecipe2(position,"rec")
            Navigation.findNavController(holder.view).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return rec.recipes.size-15
    }
}