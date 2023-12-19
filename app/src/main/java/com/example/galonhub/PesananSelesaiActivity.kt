package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PesananSelesaiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pesananselesai)

        val backButton = findViewById<Button>(R.id.back)
        backButton.setOnClickListener{
            val halamanBaru = Intent(this@PesananSelesaiActivity, HomeActivity::class.java)
            startActivity(halamanBaru)
            finish()
        }
    }
}