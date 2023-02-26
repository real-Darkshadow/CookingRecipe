package com.example.cookingrecipe.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.constants
import com.example.cookingrecipe.network.api

class repo(private val apiservice:api){

    val mdata=MutableLiveData<recipes>()
    val data:LiveData<recipes>
    get() = mdata
    suspend fun getrecipes(){
        val result=apiservice.getdata("30",constants.APP_ID)
        if (result?.body()!=null){
            mdata.postValue(result.body())
        }
        else{
            Log .e("error","error")
        }
    }

    suspend fun save() {

    }
}