package com.example.cookingrecipe.ui.seeallui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.repo.repo

class SeeallViewModel(private val repo: repo): ViewModel() {
    suspend fun save() {
        repo.save()
    }

    val data:LiveData<recipes>
    get() = repo.data

}