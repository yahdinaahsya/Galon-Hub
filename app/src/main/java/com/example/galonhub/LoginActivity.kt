package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val tombol_login = findViewById<Button>(R.id.button2)
        tombol_login.setOnClickListener{
            val halamanBaru = Intent(this@LoginActivity, HomeActivity::class.java)
            halamanBaru.putExtra("login", true)
            startActivity(halamanBaru)
        }

        val tombol_register = findViewById<TextView>(R.id.textView18)
        tombol_register.setOnClickListener{
            val halamanBaru = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(halamanBaru)
        }

        val tombol_lupaPassword = findViewById<TextView>(R.id.textView15)
        tombol_lupaPassword.setOnClickListener {
            val halamanBaru = Intent( this@LoginActivity, LupaPasswordActivity::class.java)
            startActivity(halamanBaru)
        }
    }
}