package com.example.cookingrecipe.ui.savedui.Recadapter

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R
import com.example.cookingrecipe.Room.entity
import com.example.cookingrecipe.ui.homeui.homeDirections
import com.example.cookingrecipe.ui.savedui.savedDirections
import com.squareup.picasso.Picasso

class savedAdapter(
    context: Context,
    val rec: List<entity>,
    val unsave: (String, String, String) -> Unit
): RecyclerView.Adapter<savedAdapter.viewholder>() {
    class viewholder(View: View):RecyclerView.ViewHolder(View){
        val image=View.findViewById<ImageView>(R.id.tfoodimg)
        val text=View.findViewById<TextView>(R.id.tfoodname)
        val saved=View.findViewById<ImageView>(R.id.saved)
        val view=View
        val card=view.findViewById<CardView>(R.id.card)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_savedrecycler,parent,false)
        return viewholder(lay)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val title=rec[position].name
        holder.text.text=title
        val image=rec[position].image
        Picasso.get().load(image).noFade().into(holder.image)
        val des= Html.fromHtml(rec[position].summary).toString()
        holder.card.setOnClickListener{
            val action= savedDirections.actionSavedToDetailrecipe2(position,"saved")
            Navigation.findNavController(holder.view).navigate(action)
        }
        holder.saved.setOnClickListener {
            unsave(title,image,des)
        }
    }

    override fun getItemCount(): Int {
        return rec.size
    }
}