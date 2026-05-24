package com.example.latihanrecyclerview.model

data class ItemModel(
    val id: Int,
    val title: String,
    val desc: String,
    var isChecked: Boolean = false

)
