package com.example.cookingrecipe.ui.detailui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cookingrecipe.Room.entity
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.repo.repo

class DetailrecipeViewModel(private val repo:repo) : ViewModel() {

    val data:LiveData<recipes>
    get() = repo.data
    val data2:LiveData<recipes>
        get() = repo.data2
    val roomdata:LiveData<List<entity>>
        get() = repo.roomdata



}