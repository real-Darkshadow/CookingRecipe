package com.example.cookingrecipe.ui.detailui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R
import com.example.cookingrecipe.apidata.ExtendedIngredient

class detailAdapter(val context:Context, val data: List<ExtendedIngredient>):
    RecyclerView.Adapter<detailAdapter.hello>() {
    inner class hello(View: View):RecyclerView.ViewHolder(View){
        val name=View.findViewById<TextView>(R.id.name)
        val quan=View.findViewById<TextView>(R.id.quantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hello {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_detailrecycler,parent,false)
        return hello(lay)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: hello, position: Int) {
        holder.name.text=data[position].nameClean
        holder.quan.text="${data[position].amount} ${data[position].unit}"
    }
}