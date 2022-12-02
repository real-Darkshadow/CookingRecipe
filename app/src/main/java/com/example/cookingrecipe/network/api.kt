package com.example.cookingrecipe.network
import com.example.cookingrecipe.apidata.recipes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query
interface api {
    @GET("/recipes/random")
    fun getdata(   @Query("number") number:String,
                   @Query("apiKey") apiKey:String,
                   ):Call<recipes>
}