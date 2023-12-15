package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        val tombol = findViewById<ImageView>(R.id.imageView9)
        tombol.setOnClickListener {
            val halamanBaru = Intent(this@HomeActivity, ProfilActivity::class.java)
            startActivity(halamanBaru)
        }
    }
}