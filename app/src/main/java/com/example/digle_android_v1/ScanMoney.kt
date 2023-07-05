package com.example.digle_android_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.digle_android_v1.databinding.ActivityScanMoneyBinding

class ScanMoney : AppCompatActivity() {

    private lateinit var binding: ActivityScanMoneyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanMoneyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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
            binding.btnDonation.setOnClickListener {
                if(binding.donationWrite.text.isNotEmpty()) {
                    sum = Integer.parseInt(binding.donationWrite.text.toString())
                }
                else if(binding.donationWrite.text.isEmpty()) {
                    Toast.makeText(this@ScanMoney, "숫자를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}