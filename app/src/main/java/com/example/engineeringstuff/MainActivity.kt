package com.example.engineeringstuff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.engineeringstuff.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 1st Year
        binding.year1.setOnClickListener {
            val intent = Intent(this, SubjectList::class.java)
            intent.putExtra("year", "1")
            intent.putExtra("title", "1st Year")
            startActivity(intent)
        }

        // 2nd Year
        binding.year2.setOnClickListener {
            val intent = Intent(this, SubjectList::class.java)
            intent.putExtra("year", "2")
            intent.putExtra("title", "2nd Year")
            startActivity(intent)
        }

        // 3rd Year
        binding.year3.setOnClickListener {
            val intent = Intent(this, SubjectList::class.java)
            intent.putExtra("year", "3")
            intent.putExtra("title", "3rd Year")
            startActivity(intent)
        }

        // 4th Year
        binding.year4.setOnClickListener {
            val intent = Intent(this, SubjectList::class.java)
            intent.putExtra("year", "4")
            intent.putExtra("title", "4th Year")
            startActivity(intent)
        }

        // About US
        binding.about.setOnClickListener {
            supportActionBar?.title = getString(R.string.about_us)
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    }
}