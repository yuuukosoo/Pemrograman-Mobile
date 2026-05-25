package com.example.lazyliztlatihan.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.lazyliztlatihan.model.ItemModel

class ListViewModel : ViewModel() {
    private val _items = mutableStateListOf(
        ItemModel(1, "Sample Title 1", "Sample Description 1", false),
        ItemModel(2, "Sample Title 2", "Sample Description 2", false),
        ItemModel(3, "Sample Title 3", "Sample Description 3", false),
        ItemModel(4, "Sample Title 4", "Sample Description 4", false),
        ItemModel(5, "Sample Title 5", "Sample Description 5", false)

    )

    val items: List<ItemModel> = _items

    fun toggleSwitch(index: Int) {
        val currentItem = _items[index]
        _items[index] = currentItem.copy(isChecked = !currentItem.isChecked)
    }

    fun updateItemChecked(id: Int, isChecked: Boolean) {

        val index = _items.indexOfFirst { it.id == id }

        if (index != -1) {
            _items[index] = _items[index].copy(isChecked = isChecked)
        }
    }
}