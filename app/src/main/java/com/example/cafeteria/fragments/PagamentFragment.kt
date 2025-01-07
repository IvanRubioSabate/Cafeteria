package com.example.cafeteria.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafeteria.R
import com.example.cafeteria.databinding.FragmentPagamentBinding
import com.example.cafeteria.models.Food
import com.example.cafeteria.models.FoodAdapter
import com.example.cafeteria.models.MenuAdapter
import com.example.cafeteria.viewModels.MenuViewModel

class PagamentFragment : Fragment() {

    private lateinit var binding: FragmentPagamentBinding
    private val menuViewModel: MenuViewModel by activityViewModels<MenuViewModel>()
    private lateinit var adapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPagamentBinding.inflate(inflater)

        menuViewModel.menu.observe(viewLifecycleOwner) {
            updateRecyclerViewAndPrice()
        }

        binding.pagarButton.setOnClickListener { pagar() }

        updateRecyclerViewAndPrice()

        return binding.root
    }

    private fun updateRecyclerViewAndPrice() {
        val menu = menuViewModel.menu.value

        if (menu != null) {
            adapter = MenuAdapter(menu, menuViewModel)
        } else {
            adapter = MenuAdapter(mutableListOf<Food>(), menuViewModel)
        }

        binding.recyclerViewPagament.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewPagament.adapter = adapter

        val total = menuViewModel.getTotal()

        binding.total.text = "Total: " + total.toString() + "€"
    }

    private fun pagar() {
        menuViewModel.clearMenu()
        Toast.makeText(context, "Comanda pagada correctament", Toast.LENGTH_SHORT).show()
    }

}