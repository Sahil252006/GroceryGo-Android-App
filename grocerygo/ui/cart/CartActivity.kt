package com.example.grocerygo.ui.cart

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocerygo.adapter.CartAdapter
import com.example.grocerygo.databinding.ActivityCartBinding
import com.example.grocerygo.ui.checkout.CheckoutActivity
import com.example.grocerygo.utils.CartManager

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding

    private lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityCartBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupBackButton()

        setupRecyclerView()

        updateTotal()

        openCheckout()
    }

    private fun setupRecyclerView() {

        cartAdapter =
            CartAdapter(
                CartManager.cartItems
            ) {

                updateTotal()
            }

        binding.recyclerCart.layoutManager =
            LinearLayoutManager(this)

        binding.recyclerCart.adapter =
            cartAdapter
    }

    private fun updateTotal() {

        binding.tvTotal.text =
            "Total : ₹${CartManager.getTotalPrice()}"
    }

    private fun openCheckout() {

        binding.btnCheckout.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    CheckoutActivity::class.java
                )
            )
        }
    }

    private fun checkEmptyCart() {

        if (CartManager.cartItems.isEmpty()) {

            binding.tvEmptyCart.visibility =
                android.view.View.VISIBLE

            binding.recyclerCart.visibility =
                android.view.View.GONE
        }
        else {

            binding.tvEmptyCart.visibility =
                android.view.View.GONE

            binding.recyclerCart.visibility =
                android.view.View.VISIBLE
        }
    }

    private fun setupBackButton() {

        binding.btnBack.setOnClickListener {

            onBackPressedDispatcher.onBackPressed()
        }
    }
}