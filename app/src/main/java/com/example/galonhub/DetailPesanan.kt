package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback

class DetailPesanan : AppCompatActivity() {

    private val onBackInvokedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            val halamanBaru = Intent(this@DetailPesanan, MitraTerdekatActivity::class.java)
            halamanBaru.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(halamanBaru)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_pesanan)

        onBackPressedDispatcher.addCallback(this.onBackInvokedCallback)
    }
}