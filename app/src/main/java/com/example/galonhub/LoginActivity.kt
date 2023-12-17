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

        val tombolLogin = findViewById<Button>(R.id.button2)
        tombolLogin.setOnClickListener{
            val halamanBaru = Intent(this@LoginActivity, HomeActivity::class.java)
            halamanBaru.putExtra("login", true)
            startActivity(halamanBaru)
        }

        val tombolRegister = findViewById<TextView>(R.id.textView18)
        tombolRegister.setOnClickListener{
            val halamanBaru = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(halamanBaru)
        }

        val tombolLupaPassword = findViewById<TextView>(R.id.textView15)
        tombolLupaPassword.setOnClickListener {
            val halamanBaru = Intent( this@LoginActivity, LupaPasswordActivity::class.java)
            startActivity(halamanBaru)
        }
    }
}