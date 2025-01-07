package com.example.cafeteria.viewModels

import androidx.lifecycle.ViewModel
import com.example.cafeteria.models.Food
import com.example.cafeteria.models.FoodTypes
import com.example.cafeteria.providers.FoodProvider

class PostresViewModel: ViewModel() {
    fun getPostres(): List<Food> {
        return FoodProvider.getFood().filter { it.type == FoodTypes.POSTRE }
    }
}