package com.example.grocerygo.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")

data class CartEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val productName: String,

    val productPrice: Int,

    val productImage: Int,

    val quantity: Int
)