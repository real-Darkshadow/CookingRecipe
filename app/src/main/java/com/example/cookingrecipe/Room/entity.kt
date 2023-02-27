package com.example.cookingrecipe.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class entity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val name:String,
    val image:String,
    val summary:String
)