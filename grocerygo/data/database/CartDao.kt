package com.example.grocerygo.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CartDao {

    @Insert
    suspend fun insertCartItem(
        cartEntity: CartEntity
    )

    @Query("SELECT * FROM cart_table")
    suspend fun getAllCartItems():
            List<CartEntity>

    @Query("DELETE FROM cart_table")
    suspend fun clearCart()
}