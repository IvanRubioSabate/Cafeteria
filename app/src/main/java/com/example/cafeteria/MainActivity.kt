package com.example.cafeteria

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import com.example.cafeteria.viewModels.UserViewModel
import com.example.cafeteria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.loginButton.setOnClickListener { login() }
        binding.registerButton.setOnClickListener { register() }
    }

    private fun login() {
        val loggedIn = viewModel.login(binding.userInput.text.toString(), binding.passwordInput.text.toString())
        if (loggedIn) {
            Toast.makeText(this,"Logged In succesfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Home::class.java))
        } else {
            Toast.makeText(this,"Log In failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun register() {
        val registered = viewModel.register(binding.userInput.text.toString(), binding.passwordInput.text.toString())
        if (registered) {
            Toast.makeText(this,"User registered succesfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"User already exists", Toast.LENGTH_SHORT).show()
        }
    }
}