package com.example.engineeringstuff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.engineeringstuff.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var name: String
    private lateinit var sharedPreference: SharedPreferencesManager
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreference = SharedPreferencesManager(this)
        auth = FirebaseAuth.getInstance()

        if (sharedPreference.isLogin() == true) {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }

        binding.signUp.setOnClickListener {
            name = binding.nameS.text.toString().trim()
            email = binding.emailS.text.toString().trim()
            password = binding.passwordS.text.toString().trim()
            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        sharedPreference.saveSpBoolean("spIsLogin", true)
                        startActivity(Intent(this, MainActivity::class.java))
                        finishAffinity()
                    } else {
                        Toast.makeText(this, "Unable to Create User", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}