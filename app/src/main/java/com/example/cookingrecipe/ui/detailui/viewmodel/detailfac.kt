package com.example.cookingrecipe.ui.detailui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cookingrecipe.repo.repo

class detailfac(private val repo:repo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailrecipeViewModel(repo) as T
    }
}