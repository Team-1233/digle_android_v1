package com.example.digle_android_v1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.digle_android_v1.databinding.ActivityWebPageBinding


class WebPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebPageBinding

    private var a = false
    private var b = false

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_web_page)

        val webView: WebView = binding.wv

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        webView.loadUrl("http://192.168.0.30:3000")

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                val url = request?.url.toString()
                if (url.startsWith("native://transition")) {

                    // 후원 화면으로 전환
                    val intent = Intent(this@WebPageActivity, WebPageActivity::class.java)
                    startActivity(intent)
                    return true
                }
                return super.shouldOverrideUrlLoading(view, request)
            }
        }

        binding.map.setOnClickListener {
            a = if (a) {
                binding.choose.visibility = View.INVISIBLE
                binding.arrow.visibility = View.INVISIBLE
                binding.map.setImageResource(R.drawable.map)
                false
            } else {
                binding.choose.visibility = View.VISIBLE
                binding.arrow.visibility = View.VISIBLE
                binding.map.setImageResource(R.drawable.worldwhole)
                true
            }
        }

        binding.weather.setOnClickListener {
            b = if (b) {
                binding.weather.setImageResource(R.drawable.weather)
                false
            } else {
                binding.weather.setImageResource(R.drawable.frame_180)
                true
            }
        }
    }
}