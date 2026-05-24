package com.example.latihanrecyclerview.viewmodel

import androidx.lifecycle.ViewModel
import com.example.latihanrecyclerview.model.ItemModel

class ListViewModel : ViewModel() {

    val items = mutableListOf(
        ItemModel(1, "Item Pertama", "Deskripsi item kesatu"),
        ItemModel(2, "Item Kedua", "Deskripsi item kedua"),
        ItemModel(3, "Item Ketiga", "Deskripsi item ketiga"),
        ItemModel(4, "Item Keempat", "Deskripsi item keempat"),
        ItemModel(5, "Item Kelima", "Deskripsi item kelima")
    )
}