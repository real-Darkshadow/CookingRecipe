package com.example.cookingrecipe.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface roomservice {
    @Insert
    suspend fun insertall(entity: entity)
    @Delete
    suspend fun deleteall(entity: entity)
    @Query("SELECT * FROM entity")
    fun getall():List<entity>
}