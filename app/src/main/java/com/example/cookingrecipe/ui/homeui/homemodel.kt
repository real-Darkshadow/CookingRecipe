package com.example.cookingrecipe.ui.homeui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.repo.repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class homemodel(private val repo:repo):ViewModel() {
    suspend fun save() {
        repo.save()
    }

    init {
        viewModelScope.launch(Dispatchers.IO){
            repo.getrecipes()
        }
    }
    val data:LiveData<recipes>
    get() = repo.data
}