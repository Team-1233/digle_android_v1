package com.example.digle_android_v1

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.digle_android_v1.databinding.ActivityLoadingBinding


class LoadingActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_loading)
        Loadingstart()
    }

    private fun Loadingstart() {
        val handler = Handler()
        handler.postDelayed(Runnable {
            finish()
        }, 2000)
    }
}