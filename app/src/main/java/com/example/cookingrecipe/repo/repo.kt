package com.example.cookingrecipe.repo

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cookingrecipe.Room.entity
import com.example.cookingrecipe.Room.roomservice
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.constants
import com.example.cookingrecipe.network.api

class repo(private val apiservice: api, val roomservice: roomservice){

    val mdata=MutableLiveData<recipes>()
    val data:LiveData<recipes>
    get() = mdata

    val mdata2=MutableLiveData<recipes>()
    val data2:LiveData<recipes>
        get() = mdata2

    lateinit var roomdata:List<entity>
    suspend fun getrecipes(){
        val result=apiservice.getdata("40",constants().APP_ID)
        if (result?.body()!=null){
            mdata.postValue(result.body())
        }
        else{
            Log .e("error","error")
        }
    }
    suspend fun getrecipes2(){
        val result=apiservice.getdata("30",constants().APP_ID)
        if (result?.body()!=null){
            mdata2.postValue(result.body())
        }
        else{
            Log .e("error","error")
        }
    }

    suspend fun save(name: String,image: String,des:String) {
    roomservice.insertall(entity( 0,name,image,des))
    }
    suspend fun unsave(name: String,image: String,des:String){
        roomservice.deleteall(entity( 0,name,image,des))
    }
     suspend fun getall(){
       roomdata=roomservice.getall() }
}