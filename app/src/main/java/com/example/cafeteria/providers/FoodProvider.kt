package com.example.cafeteria.providers

import com.example.cafeteria.models.Food
import com.example.cafeteria.models.FoodTypes

class FoodProvider {
    companion object {
        private val food: List<Food> = listOf(
            Food(1, FoodTypes.MENJAR, "Hamburguesa", 12.90f),
            Food(2, FoodTypes.MENJAR, "Macarrons", 9.90f),
            Food(3, FoodTypes.MENJAR, "Pizza", 11.90f),
            Food(4, FoodTypes.BEGUDA, "Aigua", 1f),
            Food(5, FoodTypes.BEGUDA, "Cafe", 1.50f),
            Food(6, FoodTypes.BEGUDA, "Fanta", 2f),
            Food(7, FoodTypes.POSTRE, "Cheescake", 3f),
            Food(8, FoodTypes.POSTRE, "Flan", 3f),
            Food(9, FoodTypes.POSTRE, "Poma", 2f)
        )

        fun getFood(): List<Food> {
            return food
        }
    }
}