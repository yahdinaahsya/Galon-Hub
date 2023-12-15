package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val tombol = findViewById<Button>(R.id.button2)
        tombol.setOnClickListener{
            val halamanBaru = Intent(this@RegisterActivity, HomeActivity::class.java)
            startActivity(halamanBaru)
        }
    }
}