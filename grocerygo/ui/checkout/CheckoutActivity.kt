package com.example.grocerygo.ui.checkout

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.grocerygo.databinding.ActivityCheckoutBinding
import com.example.grocerygo.ui.success.SuccessActivity
import androidx.lifecycle.lifecycleScope
import com.example.grocerygo.data.database.AppDatabase
import com.example.grocerygo.data.database.CartEntity
import com.example.grocerygo.utils.CartManager
import kotlinx.coroutines.launch

class CheckoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityCheckoutBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupBackButton()

        placeOrder()

    }

    private fun setupBackButton() {

        binding.btnBack.setOnClickListener {

            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun placeOrder() {

        binding.btnPlaceOrder.setOnClickListener {

            val name =
                binding.etName.text.toString().trim()

            val address =
                binding.etAddress.text.toString().trim()

            val phone =
                binding.etPhone.text.toString().trim()

            when {

                name.isEmpty() -> {

                    Toast.makeText(
                        this,
                        "Enter name",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                address.isEmpty() -> {

                    Toast.makeText(
                        this,
                        "Enter address",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                phone.length != 10 -> {

                    Toast.makeText(
                        this,
                        "Enter valid mobile number",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                binding.radioGroupPayment.checkedRadioButtonId == -1 -> {

                    Toast.makeText(
                        this,
                        "Select payment method",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val database =
                        AppDatabase.getDatabase(this)

                    lifecycleScope.launch {

                        for (item in CartManager.cartItems) {

                            database.cartDao().insertCartItem(

                                CartEntity(
                                    productName =
                                        item.product.name,

                                    productPrice =
                                        item.product.price,

                                    productImage =
                                        item.product.image,

                                    quantity =
                                        item.quantity
                                )
                            )
                        }
                    }
                    startActivity(
                        Intent(
                            this,
                            SuccessActivity::class.java
                        )
                    )

                    finish()
                }
            }
        }
    }
}