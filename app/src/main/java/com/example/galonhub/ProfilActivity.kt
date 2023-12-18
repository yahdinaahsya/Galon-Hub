package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class ProfilActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser == null){
            val halamanBaru = Intent(this@ProfilActivity, LoginActivity::class.java)
            startActivity(halamanBaru)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profil)

        auth = Firebase.auth

        val tombol = findViewById<Button>(R.id.button)
        tombol.setOnClickListener{
            Firebase.auth.signOut()
            val halamanBaru = Intent(this@ProfilActivity, HomeActivity::class.java)
            startActivity(halamanBaru)
        }
    }
}