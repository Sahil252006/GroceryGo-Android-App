package com.example.grocerygo.ui.success

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.grocerygo.databinding.ActivitySuccessBinding
import kotlin.random.Random

class SuccessActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivitySuccessBinding.inflate(layoutInflater)

        setContentView(binding.root)

        showOrderDetails()
    }

    private fun showOrderDetails() {

        val orderId =
            Random.nextInt(1000, 9999)

        binding.tvOrderId.text =
            "Order ID : #$orderId"

        binding.btnContinueShopping.setOnClickListener {

            finishAffinity()
        }
    }

}