package com.example.cookingrecipe.ui.notificationui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R

class notificationAdapter(context: Context): RecyclerView.Adapter<notificationAdapter.ViewHolders>() {
    class ViewHolders(view: View):RecyclerView.ViewHolder(view){
        val notiHeading=view.findViewById<TextView>(R.id.notihead)
        val notides=view.findViewById<TextView>(R.id.notides)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolders {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.activity_notificationsrecycler,parent,false)
        return ViewHolders(lay)
    }

    override fun onBindViewHolder(holder: ViewHolders, position: Int) {

    }

    override fun getItemCount(): Int {
        return 15
    }

}