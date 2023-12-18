package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MitraTerdekatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mitra_terdekat)

        val kembali = findViewById<Button>(R.id.button6)
        kembali.setOnClickListener{
            val halamanBaru = Intent(this@MitraTerdekatActivity, HomeActivity::class.java)
            startActivity(halamanBaru)
            finish()
        }

        val toko = findViewById<TextView>(R.id.textView85)
        toko.setOnClickListener {
            val halamanBaru = Intent( this@MitraTerdekatActivity, DetailPesananActivity::class.java)
            startActivity(halamanBaru)
            finish()
        }
    }
}