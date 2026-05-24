package com.example.lazyliztlatihan.model

data class ItemModel(
    val id: Int,
    val title: String,
    val desc: String,
    val isChecked: Boolean = false
)