package com.example.grocerygo.utils

import com.example.grocerygo.R
import com.example.grocerygo.data.model.Product

object DummyData {

    val productList = listOf(

        Product(
            1,
            "Apple",
            120,
            R.drawable.apple
        ),

        Product(
            2,
            "Banana",
            60,
            R.drawable.banana
        ),

        Product(
            3,
            "Milk",
            40,
            R.drawable.milk
        ),

        Product(
            4,
            "Bread",
            35,
            R.drawable.bread
        ),

        Product(
            5,
            "Tomato",
            50,
            R.drawable.tomato
        )
    )
}