package com.example.digle_android_v1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.digle_android_v1.databinding.ActivityTossBinding
import com.tosspayments.paymentsdk.PaymentWidget


class TossActivity : AppCompatActivity() {

    lateinit var binding: ActivityTossBinding

    private lateinit var paymentWidget: PaymentWidget

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_toss)

        paymentWidget = PaymentWidget(
            activity = this,
            clientKey = "test_ck_MGjLJoQ1aVZWNXJRP75rw6KYe2RN",
            customerKey = "tosspayment",
        )
        val methodWidget = binding.paymentWidget

        paymentWidget.renderPaymentMethods(
            methodWidget,
            1000,
            null,
            null
        )

        val intent = Intent(this, LoadingActivity::class.java)
        startActivity(intent)
    }

}