package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import org.w3c.dom.Text

class DetailPesanan : AppCompatActivity() {
    var aqua = 0
    var biasa = 0
    var galon = 0

    fun updateUI(){
        val ui_aqua = findViewById<TextView>(R.id.textView70)
        val ui_biasa = findViewById<TextView>(R.id.textView71)
        val ui_galon = findViewById<TextView>(R.id.textView78)
        val ui_total = findViewById<TextView>(R.id.textView67)

        var total = aqua+biasa

        ui_aqua.text = aqua.toString()
        ui_biasa.text = biasa.toString()
        ui_galon.text = galon.toString()
        ui_total.text = total.toString()
    }

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

        val addAqua = findViewById<TextView>(R.id.textView72)
        addAqua.setOnClickListener{
            this.aqua += 1
            this.updateUI()
        }

        val subAqua = findViewById<TextView>(R.id.textView73)
        subAqua.setOnClickListener{
            if (this.aqua != 0){
                this.aqua -= 1
            }
            this.updateUI()
        }

        val addBiasa = findViewById<TextView>(R.id.textView74)
        addBiasa.setOnClickListener{
            this.biasa += 1
            this.updateUI()
        }

        val subBiasa = findViewById<TextView>(R.id.textView59)
        subBiasa.setOnClickListener{
            if (this.biasa != 0){
                this.biasa -= 1
            }
            this.updateUI()
        }

        val addGalon = findViewById<TextView>(R.id.textView77)
        addGalon.setOnClickListener{
            this.galon += 1
            this.updateUI()
        }

        val subBGalon = findViewById<TextView>(R.id.textView63)
        subBGalon.setOnClickListener{
            if (this.galon != 0){
                this.galon -= 1
            }
            this.updateUI()
        }

        val lanjut = findViewById<Button>(R.id.button3)
        lanjut.setOnClickListener {
            val halamanBaru = Intent(this@DetailPesanan, CheckoutActivity::class.java)
            halamanBaru.putExtra("aqua", this.aqua)
            halamanBaru.putExtra("biasa", this.biasa)
            halamanBaru.putExtra("galon", this.galon)
            startActivity(halamanBaru)
        }

    }
}