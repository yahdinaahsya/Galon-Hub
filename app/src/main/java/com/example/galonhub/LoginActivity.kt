package com.example.galonhub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser != null) {
            val halamanBaru = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(halamanBaru)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        auth = Firebase.auth

        val emailInput = findViewById<EditText>(R.id.editTextText)
        val passInput = findViewById<EditText>(R.id.editTextText2)

        val tombolLogin = findViewById<Button>(R.id.button2)
        tombolLogin.setOnClickListener{
            var email: String
            var password: String

            email = emailInput.text.toString()
            password = passInput.text.toString()

            if (email == "" || password == ""){
                val toast = Toast.makeText(this@LoginActivity, "Email, password dan konfirmasi tidak boleh kosong", Toast.LENGTH_SHORT) // in Activity
                toast.show()
            }else{
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val halamanBaru = Intent( this@LoginActivity, HomeActivity::class.java)
                            halamanBaru.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(halamanBaru)
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }
            }
        }

        val tombolRegister = findViewById<TextView>(R.id.textView18)
        tombolRegister.setOnClickListener{
            val halamanBaru = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(halamanBaru)
        }

        val tombolLupaPassword = findViewById<TextView>(R.id.textView15)
        tombolLupaPassword.setOnClickListener {
            val halamanBaru = Intent( this@LoginActivity, LupaPasswordActivity::class.java)
            startActivity(halamanBaru)
        }
    }
}