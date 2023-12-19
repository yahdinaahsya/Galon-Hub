package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.compose.ui.geometry.times
import kotlin.time.times

class CheckoutActivity : AppCompatActivity() {
    val HargAqua = 14000
    val HargaBiasa = 7000
    val HargaGalon = 40000

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

        val intent = intent

        var aqua = intent.getIntExtra("aqua", 0)
        var biasa = intent.getIntExtra("biasa", 0)
        var galon = intent.getIntExtra("galon", 0)

        val jumlahAqua = findViewById<TextView>(R.id.jumlahAqua)
        jumlahAqua.text = aqua.toString()

        val jumlahBiasa  = findViewById<TextView>(R.id.jumlahBiasa)
        jumlahBiasa.text = biasa.toString()

        val jumlahGalon = findViewById<TextView>(R.id.jumlahGalon)
        jumlahGalon.text = galon.toString()

        val totalAqua = findViewById<TextView>(R.id.total_aqua)
        totalAqua.text = "Rp."+(aqua*HargAqua).toString()

        val totalBiasa = findViewById<TextView>(R.id.total_biasa)
        totalBiasa.text = "Rp."+(biasa*HargaBiasa).toString()

        val totalGalon = findViewById<TextView>(R.id.total_galon)
        totalGalon.text = "Rp."+(galon*HargaGalon).toString()

        val subtotal = findViewById<TextView>(R.id.subtotal)
        subtotal.text = "Subtotal Rp."+((aqua*HargAqua)+(biasa*HargaBiasa)+(galon*HargaGalon)).toString()

        val subtotal_2 = findViewById<TextView>(R.id.subtotal_2)
        subtotal_2.text = "Rp."+((aqua*HargAqua)+(biasa*HargaBiasa)+(galon*HargaGalon)).toString()

        var ongkir = (aqua+biasa+galon)*1000
        val textOngkir = findViewById<TextView>(R.id.ongkir)
        textOngkir.text= "Rp."+ongkir.toString()

        var admin = 2000
        val textAdmin = findViewById<TextView>(R.id.admin)
        textAdmin.text = "Rp."+admin.toString()

        var grand = admin+ongkir+((aqua*HargAqua)+(biasa*HargaBiasa)+(galon*HargaGalon))
        var textGrand = findViewById<TextView>(R.id.grand)
        textGrand.text = "Rp."+grand.toString()

    }
}