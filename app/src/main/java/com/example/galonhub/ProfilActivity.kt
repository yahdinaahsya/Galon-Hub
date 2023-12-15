package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profil)

        val tombol = findViewById<Button>(R.id.button)
        tombol.setOnClickListener{
            val halamanBaru = Intent(this@ProfilActivity, HomeActivity::class.java)
            halamanBaru.putExtra("login", false)
            startActivity(halamanBaru)
        }
    }
}