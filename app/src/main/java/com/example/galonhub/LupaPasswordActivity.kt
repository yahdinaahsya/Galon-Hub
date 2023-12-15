package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LupaPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lupa_password)

        val tombol_register = findViewById<Button>(R.id.button5)
        tombol_register.setOnClickListener{
            val halamanBaru = Intent(this@LupaPasswordActivity, LoginActivity::class.java)
            startActivity(halamanBaru)
        }
    }
}