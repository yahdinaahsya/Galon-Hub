package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.compose.ui.geometry.times
import kotlin.time.times

class CheckoutActivity : AppCompatActivity() {
    var aquaJml = 0
    var biasaJml = 0
    var galonJml = 0

    var price_aqua = 14000
    var price_biasa = 7000
    var price_galon = 40000

    private val onBackInvokedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            val halamanBaru = Intent(this@CheckoutActivity, DetailPesanan::class.java)
            halamanBaru.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(halamanBaru)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkout)

        onBackPressedDispatcher.addCallback(this.onBackInvokedCallback)

        aquaJml = intent.getIntExtra("aqua", 0)
        biasaJml = intent.getIntExtra("biasa", 0)
        galonJml = intent.getIntExtra("galon", 0)

        val aquaText = findViewById<TextView>(R.id.textView111)
        aquaText.text = aquaJml.toString()

        val biasaText = findViewById<TextView>(R.id.Biasa)
        biasaText.text = biasaJml.toString()

        val galonText = findViewById<TextView>(R.id.textView119)
        galonText.text = galonJml.toString()

        val aquaTotal = findViewById<TextView>(R.id.textView)
        aquaTotal.text = "Rp."+(aquaJml*price_aqua).toString()

        val biasaTotal = findViewById<TextView>(R.id.BiasaTotal)
        biasaTotal.text = "Rp."+(biasaJml*price_biasa).toString()

        val galonTotal = findViewById<TextView>(R.id.textView120)
        galonTotal.text = "Rp."+(galonJml*price_galon).toString()

        var total = (aquaJml*price_aqua) + (biasaJml*price_biasa) + (galonJml*price_galon)
        val totalText = findViewById<TextView>(R.id.textView118)
        totalText.text = "Rp."+total.toString()

        val subTotalText = findViewById<TextView>(R.id.textView133)
        subTotalText.text = "Rp."+total.toString()

        var nilaiOngkir = (2000*(galonJml+aquaJml+galonJml))
        val ongkir = findViewById<TextView>(R.id.textView133)
        ongkir.text = nilaiOngkir.toString()

        var nilaiAdmin = 1000
        val admin = findViewById<TextView>(R.id.textView334)
        admin.text = "Rp."+nilaiAdmin.toString()

        var grandTotal = nilaiAdmin+nilaiOngkir+total
        val grand = findViewById<TextView>(R.id.textView445)
        grand.text = grandTotal.toString()

    }
}