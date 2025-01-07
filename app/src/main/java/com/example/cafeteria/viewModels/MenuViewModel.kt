package com.example.cafeteria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cafeteria.models.Food
import com.example.cafeteria.providers.FoodProvider
import java.math.RoundingMode
import java.text.DecimalFormat

class MenuViewModel: ViewModel() {
    private val _menu: MutableLiveData<List<Food>> = MutableLiveData<List<Food>>()
    val menu: LiveData<List<Food>> = _menu

    fun addProduct(id: Int) {
        val list = mutableListOf<Food>()
        _menu.value?.let { list.addAll(it) }
        FoodProvider.getFood().find { it.id == id }?.let { list.add(it) }
        _menu.value = list
    }

    fun getTotal(): Float {
        var total = _menu.value?.map{ it.price }?.sum()
        if (total == null) {
            total = 0f
        }
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(total).toFloat()
    }

    fun deleteProduct(position: Int) {
        val list = mutableListOf<Food>()
        _menu.value?.let { list.addAll(it) }
        list.removeAt(position)
        _menu.value = list
    }

    fun clearMenu() {
        val list = mutableListOf<Food>()
        _menu.value = list
    }

}