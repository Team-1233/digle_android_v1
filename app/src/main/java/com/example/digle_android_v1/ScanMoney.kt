package com.example.digle_android_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.digle_android_v1.databinding.ActivityScanMoneyBinding

class ScanMoney : AppCompatActivity() {

    private lateinit var binding: ActivityScanMoneyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scan_money)

        var sum: Int = 0
        binding.radioZero.setOnClickListener {
            sum = 1000
        }
        binding.radioOne.setOnClickListener {
            sum = 10000
        }
        binding.radioThree.setOnClickListener {
            sum = 30000
        }
        binding.radioFive.setOnClickListener {
            sum = 50000
        }
        binding.radioTen.setOnClickListener {
            sum = 100000
        }
        binding.radioFifteen.setOnClickListener {
            sum = 150000
        }
        binding.radioTwenty.setOnClickListener {
            sum = 200000
        }
        binding.radioThirty.setOnClickListener {
            sum = 300000
        }

        binding.radioWrite.setOnClickListener {
            binding.bt.setOnClickListener {
                if (binding.donationWrite.text.isNotEmpty()) {
                    sum = Integer.parseInt(binding.donationWrite.text.toString())
                } else if (binding.donationWrite.text.isEmpty()) {
                    Toast.makeText(this@ScanMoney, "숫자를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.bt.setOnClickListener {
            val intent = Intent(this, TossActivity::class.java)
            intent.putExtra("asdf", 0)
            startActivity(intent)
        }

        binding.back.setOnClickListener {
            finish()
        }
    }
}