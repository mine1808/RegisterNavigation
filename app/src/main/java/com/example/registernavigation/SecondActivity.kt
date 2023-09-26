package com.example.registernavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registernavigation.MainActivity.Companion.EXTRA_EMAIL
import com.example.registernavigation.MainActivity.Companion.EXTRA_NAME
import com.example.registernavigation.MainActivity.Companion.EXTRA_PHONE
import com.example.registernavigation.databinding.ActivityMainBinding
import com.example.registernavigation.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_NAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra(EXTRA_PHONE)

        with(binding) {
            isiHomepage.text = "Welcome $username \nYour $email has been activated \nYour $phone has been registered"

            btnLogout.setOnClickListener {
                val intentToMainActivity = Intent(this@SecondActivity, MainActivity::class.java)
                startActivity(intentToMainActivity)
            }
        }
    }
}