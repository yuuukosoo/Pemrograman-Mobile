package com.example.latihanrecyclerview.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanrecyclerview.adapter.ItemAdapter
import com.example.latihanrecyclerview.databinding.ActivityMainBinding
import com.example.latihanrecyclerview.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvItems.layoutManager = LinearLayoutManager(this)
        binding.rvItems.adapter = ItemAdapter(viewModel.items)
    }
}