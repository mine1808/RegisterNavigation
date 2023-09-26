package com.example.registernavigation

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registernavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnRegister.setOnClickListener {
                if (textUsername.text.isEmpty() || textEmail.text.isEmpty() || textPassword.text.isEmpty() || textPhone.text.isEmpty()){
                    val warning = "Tolong isi yang kosong"
                    Toast.makeText(this@MainActivity, warning, Toast.LENGTH_SHORT).show()
                }
                else{
                    if (checkbox.isChecked){
                        val intendToSecondActivity =
                            Intent(this@MainActivity, SecondActivity::class.java)
                        val username = textUsername.text.toString()
                        intendToSecondActivity.putExtra(EXTRA_NAME, username)
                        startActivity(intendToSecondActivity)
                        val email = textEmail.text.toString()
                        intendToSecondActivity.putExtra(EXTRA_EMAIL, email)
                        startActivity(intendToSecondActivity)
                        val phone = textPhone.text.toString()
                        intendToSecondActivity.putExtra(EXTRA_PHONE, phone)
                        startActivity(intendToSecondActivity)
                    }
                    else{
                        val  termsAndCondition = "Centang dulu baru register"
                        Toast.makeText(this@MainActivity, termsAndCondition, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}