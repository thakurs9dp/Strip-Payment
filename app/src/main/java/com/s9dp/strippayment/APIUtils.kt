package com.s9dp.strippayment

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIUtils {


    fun getApiInterface() : ApiServices {
        return Retrofit.Builder()
            .baseUrl("https://api.stripe.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiServices::class.java)
    }

}