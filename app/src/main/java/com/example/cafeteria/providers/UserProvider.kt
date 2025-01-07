package com.example.cafeteria.providers

import com.example.cafeteria.models.User
import com.example.cafeteria.models.UserPassword

class UserProvider {
    companion object {
        private val Users: MutableList<UserPassword> = mutableListOf(
            UserPassword(User(1, "ivan"), "1234"),
            UserPassword(User(2, "camilla"), "1234"),
            UserPassword(User(3, "millia"), "1234")
        )

        /*
        Gets user by username and password
        Returns the user or null
         */
        fun getUser(username: String, password: String): User? {
            val user = Users.find { it.user.username == username.lowercase() && it.password == password }
            return user?.user
        }

        /*
        Adds user to list if username is not already taken
        Returns true when user is added, if not it returns false
         */
        fun addUser(username: String, password: String): Boolean {
            val lastUser = Users.last()

            val userExists = Users.find { it.user.username == username.lowercase() }

            if (userExists != null) {
                return false
            }

            Users.add(UserPassword(User(lastUser.user.id + 1, username.lowercase()), password))
            return true
        }
    }
}