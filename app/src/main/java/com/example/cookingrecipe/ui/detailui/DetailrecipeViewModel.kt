package com.example.cookingrecipe.ui.detailui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.repo.repo

class DetailrecipeViewModel(private val repo:repo) : ViewModel() {

    val data:LiveData<recipes>
    get() = repo.data



}