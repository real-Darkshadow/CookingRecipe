package com.example.cookingrecipe.ui.savedui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookingrecipe.Room.entity
import com.example.cookingrecipe.repo.repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class savedmodel(private val repo:repo):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repo.getall()
        }
    }

    val roomdata: LiveData<List<entity>>
    get() = repo.roomdata

    fun unsave(name: String,image: String,des:String){
        viewModelScope.launch(Dispatchers.IO){
            repo.unsave(name, image, des)
        }
    }


}

