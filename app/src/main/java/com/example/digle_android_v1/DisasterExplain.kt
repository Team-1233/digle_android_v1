package com.example.digle_android_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.digle_android_v1.databinding.ActivityDisasterExplainBinding

class DisasterExplain : AppCompatActivity() {

    private lateinit var binding: ActivityDisasterExplainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisasterExplainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = Intent(this, ScanMoney::class.java)

        binding.btnGoDonation.setOnClickListener {
            if (binding.checkAgree.isChecked) {
                startActivity(intent)
            }
            else {
                Toast.makeText(this@DisasterExplain, "이용약관에 동의해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}