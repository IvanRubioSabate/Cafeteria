package com.example.cafeteria.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cafeteria.databinding.FragmentPostresBinding
import com.example.cafeteria.models.FoodAdapter
import com.example.cafeteria.viewModels.MenuViewModel
import com.example.cafeteria.viewModels.PostresViewModel

class PostresFragment : Fragment() {

    private lateinit var binding: FragmentPostresBinding
    private lateinit var adapter: FoodAdapter
    private val viewModel: PostresViewModel by viewModels<PostresViewModel>()
    private val menuViewModel: MenuViewModel by activityViewModels<MenuViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostresBinding.inflate(inflater)

        val postres = viewModel.getPostres()

        adapter = FoodAdapter(postres, menuViewModel)

        binding.recyclerViewPostres.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerViewPostres.adapter = adapter

        return binding.root
    }

}