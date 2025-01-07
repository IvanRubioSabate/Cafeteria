package com.example.cafeteria.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafeteria.R
import com.example.cafeteria.databinding.FragmentMenjarsBinding
import com.example.cafeteria.models.FoodAdapter
import com.example.cafeteria.viewModels.MenjarsViewModel
import com.example.cafeteria.viewModels.MenuViewModel

class MenjarsFragment : Fragment() {

    private lateinit var binding: FragmentMenjarsBinding
    private val viewModel: MenjarsViewModel by viewModels<MenjarsViewModel>()
    private val menuViewModel: MenuViewModel by activityViewModels<MenuViewModel>()
    private lateinit var adapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenjarsBinding.inflate(inflater)

        val menjars = viewModel.getMenjars()

        adapter = FoodAdapter(menjars, menuViewModel)

        binding.recyclerViewMenjars.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerViewMenjars.adapter = adapter

        return binding.root
    }
}