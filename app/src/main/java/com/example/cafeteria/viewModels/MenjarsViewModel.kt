package com.example.cafeteria.viewModels

import androidx.lifecycle.ViewModel
import com.example.cafeteria.models.Food
import com.example.cafeteria.models.FoodTypes
import com.example.cafeteria.providers.FoodProvider

class MenjarsViewModel: ViewModel() {
    fun getMenjars(): List<Food> {
        return FoodProvider.getFood().filter { it.type == FoodTypes.MENJAR }
    }
}