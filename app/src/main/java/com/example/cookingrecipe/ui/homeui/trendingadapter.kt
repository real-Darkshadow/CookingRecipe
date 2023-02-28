package com.example.cookingrecipe.ui.homeui

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
import com.example.cookingrecipe.apidata.recipes
import com.squareup.picasso.Picasso
import kotlin.reflect.KFunction3

class trendingadapter(val context: Context, val rec: recipes, val onsave: KFunction3<String, String, String, Unit>): RecyclerView.Adapter<trendingadapter.viewholder>() {

    class viewholder(view: View):RecyclerView.ViewHolder(view){
        val image=view.findViewById<ImageView>(R.id.tfoodimg)
        val text=view.findViewById<TextView>(R.id.tfoodname)
        val view=view
        val card=view.findViewById<CardView>(R.id.card)
        val save=view.findViewById<ImageView>(R.id.save)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_trendingadapter,parent,false)
        return viewholder(lay)
    }
    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val title=rec.recipes[position].title
        holder.text.text=title
        val image=rec.recipes[position].image
        Picasso.get().load(image).noFade().into(holder.image)
        val des=Html.fromHtml(rec.recipes[position].instructions).toString()
        val exing=rec.recipes[position].extendedIngredients
        holder.card.setOnClickListener{
            val action=homeDirections.actionHome2ToDetailrecipe2(position,"trending")
            Navigation.findNavController(holder.view).navigate(action)
        }
        holder.save.setOnClickListener {
            onsave(title,image,des)
        }
    }

    override fun getItemCount(): Int {
        return rec.recipes.size-15
    }
}