package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        val intent = intent
        val statusLogin = intent.getBooleanExtra("login", false)

        val login = statusLogin

        val tombol = findViewById<ImageView>(R.id.imageView9)
        tombol.setOnClickListener {
            if (login){
                val halamanBaru = Intent(this@HomeActivity, ProfilActivity::class.java)
                startActivity(halamanBaru)
            }else{
                val halamanBaru = Intent(this@HomeActivity, LoginActivity::class.java)
                startActivity(halamanBaru)
            }
        }
    }
}