package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback

class WawasanActivity : AppCompatActivity() {

    private val onBackInvokedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            val halamanBaru = Intent(this@WawasanActivity, HomeActivity::class.java)
            halamanBaru.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(halamanBaru)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insight)

        onBackPressedDispatcher.addCallback(onBackInvokedCallback)

    }
}