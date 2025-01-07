package com.example.cafeteria.viewModels

import androidx.lifecycle.ViewModel
import com.example.cafeteria.models.User
import com.example.cafeteria.providers.UserProvider

class UserViewModel: ViewModel() {
    private lateinit var _user: User
    val user: User
        get() = _user

    fun login(username: String, password: String): Boolean {
        val user = UserProvider.getUser(username, password)
        if (user != null) {
            _user = user
            return true;
        }
        return false
    }

    fun register(username: String, password: String): Boolean {
        return UserProvider.addUser(username, password)
    }
}