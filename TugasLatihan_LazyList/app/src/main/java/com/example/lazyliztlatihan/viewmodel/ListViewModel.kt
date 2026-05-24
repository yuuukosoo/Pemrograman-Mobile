package com.example.lazyliztlatihan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.example.lazyliztlatihan.model.ItemModel

class ListViewModel : ViewModel() {

    val items = mutableStateListOf(
        ItemModel(1, "Item Pertama", "Deskripsi item kesatu"),
        ItemModel(2, "Item Kedua", "Deskripsi item kedua"),
        ItemModel(3, "Item Ketiga", "Deskripsi item ketiga"),
        ItemModel(4, "Item Keempat", "Deskripsi item keempat"),
        ItemModel(5, "Item Kelima", "Deskripsi item kelima")
    )


    fun updateItemChecked(itemId: Int, isChecked: Boolean) {
        val index = items.indexOfFirst { it.id == itemId }
        if (index != -1) {

            items[index] = items[index].copy(isChecked = isChecked)
        }
    }
}