package com.example.cookingrecipe.apidata

data class AnalyzedInstruction(
    val name: String,
    val steps: List<Step>
)