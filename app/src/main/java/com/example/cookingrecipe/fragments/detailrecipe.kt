package com.example.cookingrecipe.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.cookingrecipe.R
import com.squareup.picasso.Picasso

class detailrecipe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailrecipe)
        val imageurl=intent.extras?.getString("imageurl")
        val image=findViewById<ImageView>(R.id.tfoodimg)
        val title= intent.extras?.getString("title")
        val text=findViewById<TextView>(R.id.title)
        text.text=title
        (Picasso.get().load(imageurl).into(image))
    }
}