package com.example.grocerygo.utils

import com.example.grocerygo.data.model.CartItem
import com.example.grocerygo.data.model.Product

object CartManager {

    val cartItems = mutableListOf<CartItem>()

    fun addToCart(product: Product) {

        val existingItem =
            cartItems.find {

                it.product.id == product.id
            }

        if (existingItem != null) {

            existingItem.quantity++
        }
        else {

            cartItems.add(
                CartItem(product)
            )
        }
    }

    fun getTotalPrice(): Int {

        var total = 0

        for (item in cartItems) {

            total +=
                item.product.price * item.quantity
        }

        return total
    }
}