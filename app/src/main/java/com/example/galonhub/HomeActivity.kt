package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class HomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        auth = Firebase.auth
        val currentUser = auth.currentUser

        val intent = intent

        val tombol = findViewById<ImageView>(R.id.imageView9)
        tombol.setOnClickListener {
            if (currentUser != null) {
                val halamanBaru = Intent(this@HomeActivity, ProfilActivity::class.java)
                startActivity(halamanBaru)
                finish()
            }else{
                val halamanBaru = Intent(this@HomeActivity, LoginActivity::class.java)
                startActivity(halamanBaru)
                finish()
            }
        }

        val tombolPesan = findViewById<TextView>(R.id.textView24)
        tombolPesan.setOnClickListener {
            if (currentUser != null){
                val halamanBaru = Intent( this@HomeActivity, MitraTerdekatActivity::class.java)
                startActivity(halamanBaru)
                finish()
            }else{
                val halamanBaru = Intent( this@HomeActivity, LoginActivity::class.java)
                startActivity(halamanBaru)
                finish()
            }

        }

        val tombolWawasan = findViewById<TextView>(R.id.textView25)
        tombolWawasan.setOnClickListener{
            val halamanBaru = Intent( this@HomeActivity, WawasanActivity::class.java)
            startActivity(halamanBaru)
            finish()
        }
    }
}