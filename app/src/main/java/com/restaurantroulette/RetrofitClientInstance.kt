package com.restaurantroulette

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    private var retrofit : Retrofit? = null
    private val BASE_URL = "https://opentable.herokuapp.com"

    val retrofitInstance : Retrofit?
        get() {
            // checks if this object has been created
            if (retrofit == null) {
                // if not, it creates it here
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}