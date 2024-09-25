package com.s9dp.strippayment

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.stripe.android.PaymentConfiguration
import com.stripe.android.paymentsheet.PaymentSheet
import com.stripe.android.paymentsheet.PaymentSheetResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var paymentSheet: PaymentSheet
    private var apiInterface = APIUtils.getApiInterface()
    private var customerID: String = ""
    private var ephemeralKey: String = ""
    private var clientSecret: String = ""
    private lateinit var bntPayment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PaymentConfiguration.init(this, BuildConfig.STRIP_PUBLISHABLE_API)

        getCustomerId()
        paymentSheet = PaymentSheet(this, ::onPaymentSheetResult)
        bntPayment = findViewById(R.id.bntPayment)
        bntPayment.setOnClickListener {
            paymentFlow()
        }

    }

    private fun getCustomerId() {
        lifecycleScope.launch(Dispatchers.IO) {
            val response = apiInterface.getCustomer()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful && response.body() != null) {
                    customerID = response.body()?.id.toString()
                    getEphemeralKey(customerID)
                }
            }
        }
    }

    private fun getEphemeralKey(customerID: String?) {
        lifecycleScope.launch(Dispatchers.IO) {
            val response = customerID?.let { apiInterface.getEphemeralKey(it) }
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful && response.body() != null) {
                    ephemeralKey = response.body()?.id.toString()
                    getPaymentIntent(customerID)
                }
            }
        }
    }

    private fun getPaymentIntent(customerID: String?) {
        lifecycleScope.launch(Dispatchers.IO) {
            val response = customerID?.let { apiInterface.paymentIntent(it) }
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful && response.body() != null) {
                    clientSecret = response.body()!!.clientSecret
                    Toast.makeText(this@MainActivity, "Payment Processed", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun onPaymentSheetResult(paymentSheetResult: PaymentSheetResult) {
        if (paymentSheetResult is PaymentSheetResult.Completed) {
            paymentFlow()
        }
    }


    private fun paymentFlow() {
        paymentSheet.presentWithPaymentIntent(
            clientSecret, PaymentSheet.Configuration(
                "XYZ", PaymentSheet.CustomerConfiguration(customerID, ephemeralKey)
            )
        )
    }

}