package com.example.cafeteria.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cafeteria.databinding.FragmentBegudesBinding
import com.example.cafeteria.models.FoodAdapter
import com.example.cafeteria.viewModels.BegudesViewModel
import com.example.cafeteria.viewModels.MenuViewModel

class BegudesFragment : Fragment() {

    private lateinit var binding: FragmentBegudesBinding
    private lateinit var adapter: FoodAdapter
    private val viewModel: BegudesViewModel by viewModels<BegudesViewModel>()
    private val menuViewModel: MenuViewModel by activityViewModels<MenuViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBegudesBinding.inflate(inflater)

        val begudes = viewModel.getBegudes()

        adapter = FoodAdapter(begudes, menuViewModel)

        binding.recyclerViewBegudes.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerViewBegudes.adapter = adapter

        return binding.root
    }
}