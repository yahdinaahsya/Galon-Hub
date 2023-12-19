package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class HomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    fun extractUsername(email: String): String {
        // Split the email address at the "@" symbol
        val parts = email.split("@")

        // The username is the first part of the split
        return parts.first()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        auth = Firebase.auth
        val currentUser = auth.currentUser

        val intent = intent

        val pesan = findViewById<LinearLayout>(R.id.pesan)
        pesan.setOnClickListener {
            if (currentUser != null) {
                val halamanBaru = Intent(this@HomeActivity, MitraTerdekatActivity::class.java)
                startActivity(halamanBaru)
                finish()
            }else{
                val halamanBaru = Intent(this@HomeActivity, LoginActivity::class.java)
                startActivity(halamanBaru)
                finish()
            }
        }

        val tombolWawasan = findViewById<LinearLayout>(R.id.wawasan)
        tombolWawasan.setOnClickListener{
            val halamanBaru = Intent( this@HomeActivity, WawasanActivity::class.java)
            startActivity(halamanBaru)
            finish()
        }

        var email = currentUser?.email
        val nama = findViewById<TextView>(R.id.Sapa)
        nama.text = "Halo " + extractUsername(email.toString())
    }

}