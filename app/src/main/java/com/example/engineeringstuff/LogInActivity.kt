package com.example.engineeringstuff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.engineeringstuff.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {
    private lateinit var sharedPreference: SharedPreferencesManager
    private lateinit var binding: ActivityLogInBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        sharedPreference = SharedPreferencesManager(this)
        auth = FirebaseAuth.getInstance()

        if (sharedPreference.isLogin() == true) {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }

        binding.logIn.setOnClickListener {
            val email = binding.emailL.text.toString().trim()
            val password = binding.passwordL.text.toString().trim()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        sharedPreference.saveSpBoolean("spIsLogin", true)
                        startActivity(Intent(this, MainActivity::class.java))
                        finishAffinity()
                    } else {
                        Toast.makeText(this, "Unable to Log In", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.signUpL.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}