package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class ProfilActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private val onBackInvokedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            val halamanBaru = Intent(this@ProfilActivity, HomeActivity::class.java)
            startActivity(halamanBaru)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser == null){
            val halamanBaru = Intent(this@ProfilActivity, LoginActivity::class.java)
            startActivity(halamanBaru)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profil)

        onBackPressedDispatcher.addCallback(this.onBackInvokedCallback)

        auth = Firebase.auth

        val tombol = findViewById<Button>(R.id.btnkeluarprofil)
        tombol.setOnClickListener{
            Firebase.auth.signOut()
            val halamanBaru = Intent(this@ProfilActivity, HomeActivity::class.java)
            startActivity(halamanBaru)
            finish()
        }
    }
}