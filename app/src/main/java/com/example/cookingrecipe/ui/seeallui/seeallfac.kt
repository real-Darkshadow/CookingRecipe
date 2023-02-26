package com.example.cookingrecipe.ui.seeallui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cookingrecipe.repo.repo

class seeallfac(private val repo: repo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SeeallViewModel(repo) as T
    }
}