package com.example.cookingrecipe.ui.savedui.Recadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R
import com.example.cookingrecipe.Room.entity
import com.example.cookingrecipe.ui.savedui.savedDirections
import com.squareup.picasso.Picasso

class savedAdapter(context: Context, val data: List<entity>): RecyclerView.Adapter<savedAdapter.viewholder>() {
    class viewholder(View: View):RecyclerView.ViewHolder(View){
        val image=View.findViewById<ImageView>(R.id.tfoodimg)
        val title=View.findViewById<TextView>(R.id.tfoodname)
        val save=View.findViewById<ImageView>(R.id.save)
        val view=View

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_savedrecycler,parent,false)
        return viewholder(lay)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.title.text=data[position].name
        Picasso.get().load(data[position].image).into(holder.image)
        holder.image.setOnClickListener{
            val action= savedDirections.actionSavedToDetailrecipe2(position,"saved")
            Navigation.findNavController(holder.view).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}