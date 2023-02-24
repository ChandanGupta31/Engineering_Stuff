package com.example.engineeringstuff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class PDFviewer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfviewer)
        supportActionBar?.hide()



        val url = intent.getStringExtra("url")
        val pdf : WebView = findViewById(R.id.pdf)
        pdf.webViewClient = WebViewClient()
        pdf.settings.setSupportZoom(true)
        pdf.settings.javaScriptEnabled = true
        if (url != null) {
            pdf.loadUrl(url)
        }
    }
}