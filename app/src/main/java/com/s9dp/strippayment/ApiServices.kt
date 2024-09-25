package com.s9dp.strippayment

import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiServices {

    @Headers("Authorization: Bearer ${BuildConfig.STRIP_SECRET_KEY}")
    @POST("v1/customers")
    suspend fun getCustomer(): Response<Customer>

    @Headers(
        "Authorization: Bearer ${BuildConfig.STRIP_SECRET_KEY}", "Stripe-Version: 2024-06-20"
    )
    @POST("v1/ephemeral_keys")
    suspend fun getEphemeralKey(@Query("customer") customer: String): Response<Ephemeral>

    @Headers("Authorization: Bearer ${BuildConfig.STRIP_SECRET_KEY}")
    @POST("v1/payment_intents")
    suspend fun paymentIntent(
        @Query("customer") customer: String,
        @Query("amount") amount: String = "100",
        @Query("currency") currency: String ="inr",
        @Query("automatic_payment_methods[enabled]") paymentEnable: Boolean = true

    ): Response<PaymentIntent>

}