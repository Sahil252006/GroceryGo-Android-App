package com.example.grocerygo.ui.home

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocerygo.adapter.ProductAdapter
import com.example.grocerygo.data.model.Product
import com.example.grocerygo.databinding.ActivityHomeBinding
import com.example.grocerygo.ui.cart.CartActivity
import com.example.grocerygo.utils.DummyData

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var productAdapter: ProductAdapter

    private var productList =
        DummyData.productList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupRecyclerView()

        setupSearch()

        openCartScreen()
    }

    private fun setupRecyclerView() {

        productAdapter =
            ProductAdapter(productList)

        binding.recyclerProducts.layoutManager =
            LinearLayoutManager(this)

        binding.recyclerProducts.adapter =
            productAdapter

        binding.recyclerProducts
            .setHasFixedSize(true)

        binding.recyclerProducts
            .layoutAnimation = null
    }

    private fun setupSearch() {

        binding.etSearch.addTextChangedListener(

            object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {

                    filterProducts(s.toString())
                }

                override fun afterTextChanged(
                    s: Editable?
                ) {
                }
            }
        )
    }

    private fun filterProducts(query: String) {

        val filteredList =
            mutableListOf<Product>()

        for (product in productList) {

            if (
                product.name.contains(
                    query,
                    ignoreCase = true
                )
            ) {

                filteredList.add(product)
            }
        }

        productAdapter.updateList(filteredList)
    }

    private fun openCartScreen() {

        binding.btnCart.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    CartActivity::class.java
                )
            )
        }
    }
}