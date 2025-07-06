package com.example.learn_6

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val webViewMySite = findViewById<WebView>(R.id.webViewMySite)
        webViewSet(webViewMySite)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSet(webview: WebView){
        webview.webViewClient = WebViewClient()

        webview.apply {
            settings.safeBrowsingEnabled = true
            settings.javaScriptEnabled = true
            loadUrl("https://musfiktamim.vercel.app")
        }
    }
}