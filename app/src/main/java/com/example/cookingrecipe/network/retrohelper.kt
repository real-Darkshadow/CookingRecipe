package com.example.cookingrecipe.network

import com.example.cookingrecipe.constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrohelper {

    fun getinstance():Retrofit{
        return Retrofit.Builder().baseUrl(constants().BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}