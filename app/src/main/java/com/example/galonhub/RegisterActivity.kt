package com.example.galonhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val halamanBaru = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(halamanBaru)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        auth = Firebase.auth

        val emailTextView = findViewById<EditText>(R.id.editTextText)
        val passTextView = findViewById<EditText>(R.id.editTextText2)
        val confirmTextView = findViewById<EditText>(R.id.editTextText7)

        val tombol = findViewById<Button>(R.id.button2)
        tombol.setOnClickListener{
            var email: String
            var password: String
            var confirm: String

            email = emailTextView.text.toString()
            password = passTextView.text.toString()
            confirm = confirmTextView.text.toString()

            if (email == "" || password == "" || confirm == ""){
                val toast = Toast.makeText(this@RegisterActivity, "Email, password dan konfirmasi tidak boleh kosong", Toast.LENGTH_SHORT) // in Activity
                toast.show()
            }else{
                if (password != confirm){
                    val toast = Toast.makeText(this@RegisterActivity, "Password tidak sama", Toast.LENGTH_SHORT) // in Activity
                    toast.show()
                }else{
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                val halamanBaru = Intent(this@RegisterActivity, LoginActivity::class.java)
                                halamanBaru.putExtra("login", true)
                                startActivity(halamanBaru)
                            } else {
                                val toast = Toast.makeText(this@RegisterActivity, "Gagal membuat akun", Toast.LENGTH_SHORT) // in Activity
                                toast.show()
                            }
                        }
                }
            }
        }

        val tombol_login = findViewById<TextView>(R.id.textView18)
        tombol_login.setOnClickListener{
            val halamanBaru = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(halamanBaru)
        }
    }
}