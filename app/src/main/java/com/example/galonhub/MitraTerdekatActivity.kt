package com.example.galonhub

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue

class MitraTerdekatActivity : AppCompatActivity() {

    private val onBackInvokedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            val halamanBaru = Intent(this@MitraTerdekatActivity, HomeActivity::class.java)
            halamanBaru.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(halamanBaru)
            finish()
        }
    }
    override fun onStart() {
        super.onStart()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mitra_terdekat)

        val ro = findViewById<TextView>(R.id.textView85)
        ro.setOnClickListener {
            val halamanBaru = Intent(this@MitraTerdekatActivity, DetailPesanan::class.java)
            startActivity(halamanBaru)
        }

        val kembali = findViewById<Button>(R.id.button6)
        kembali.setOnClickListener{
            val halamanBaru = Intent(this@MitraTerdekatActivity, HomeActivity::class.java)
            startActivity(halamanBaru)
            finish()
        }
    }
}