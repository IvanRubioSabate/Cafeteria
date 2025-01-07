package com.example.cafeteria.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.cafeteria.R
import com.example.cafeteria.databinding.FragmentTotalBinding
import com.example.cafeteria.viewModels.MenuViewModel

class TotalFragment : Fragment() {
    private lateinit var binding: FragmentTotalBinding
    private val menuViewModel: MenuViewModel by activityViewModels<MenuViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTotalBinding.inflate(inflater)

        menuViewModel.menu.observe(viewLifecycleOwner) {
            binding.totalText.text = "Total: " + menuViewModel.getTotal().toString() + "€"
        }

        return binding.root
    }

}