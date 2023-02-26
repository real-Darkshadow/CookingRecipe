package com.example.cookingrecipe.ui.homeui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cookingrecipe.repo.repo

class homefac(private val repo:repo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return homemodel(repo) as T
    }
}