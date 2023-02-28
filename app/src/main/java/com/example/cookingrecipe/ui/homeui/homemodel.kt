package com.example.cookingrecipe.ui.homeui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.repo.repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class homemodel(private val repo:repo):ViewModel() {
    suspend fun save(name: String,image: String,des:String) {
        repo.save(name,image,des)
    }

    init {
        viewModelScope.launch(Dispatchers.IO){
            repo.getrecipes()
            repo.getrecipes2()
        }
    }
    val data:LiveData<recipes>
    get() = repo.data

    val data2:LiveData<recipes>
        get() = repo.data2
}