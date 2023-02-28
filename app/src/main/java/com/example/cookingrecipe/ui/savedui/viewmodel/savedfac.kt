package com.example.cookingrecipe.ui.savedui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cookingrecipe.repo.repo

class savedfac(private val repo: repo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return savedmodel(repo) as T
    }

}