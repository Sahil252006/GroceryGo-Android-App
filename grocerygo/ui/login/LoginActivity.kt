package com.example.grocerygo.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.grocerygo.databinding.ActivityLoginBinding
import com.example.grocerygo.ui.home.HomeActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            validateLogin()
        }
    }

    private fun validateLogin() {

        val mobile =
            binding.etMobile.text.toString().trim()

        val otp =
            binding.etOtp.text.toString().trim()

        when {

            mobile.isEmpty() -> {

                Toast.makeText(
                    this,
                    "Enter mobile number",
                    Toast.LENGTH_SHORT
                ).show()
            }

            mobile.length != 10 -> {

                Toast.makeText(
                    this,
                    "Enter valid mobile number",
                    Toast.LENGTH_SHORT
                ).show()
            }

            otp.isEmpty() -> {

                Toast.makeText(
                    this,
                    "Enter OTP",
                    Toast.LENGTH_SHORT
                ).show()
            }

            otp != "1234" -> {

                Toast.makeText(
                    this,
                    "Invalid OTP",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else -> {

                Toast.makeText(
                    this,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(
                        this,
                        HomeActivity::class.java
                    )
                )

                finish()
            }
        }
    }
}