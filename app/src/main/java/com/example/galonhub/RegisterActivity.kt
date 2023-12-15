package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val tombol = findViewById<Button>(R.id.button2)
        tombol.setOnClickListener{
            val halamanBaru = Intent(this@RegisterActivity, LoginActivity::class.java)
            halamanBaru.putExtra("login", true)
            startActivity(halamanBaru)
        }

        val tombol_login = findViewById<TextView>(R.id.textView18)
        tombol_login.setOnClickListener{
            val halamanBaru = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(halamanBaru)
        }
    }
}