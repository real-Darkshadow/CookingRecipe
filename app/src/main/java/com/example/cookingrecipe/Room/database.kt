package com.example.cookingrecipe.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [entity::class], version = 1)
abstract  class database: RoomDatabase() {
    abstract fun dao():roomservice
    companion object{
        @Volatile
        private var INSTANCE: database?=null

        fun getDatabase(context: Context): database{
            if (INSTANCE==null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,database::class.java,"user-recipes").build()
                } }
            return  INSTANCE!!}
    }
}