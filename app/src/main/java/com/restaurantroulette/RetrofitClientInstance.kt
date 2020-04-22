package com.restaurantroulette

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    private var retrofit : Retrofit? = null
    private val BASE_URL : String = "https://maps.googleapis.com/maps/api/place/"
    //?input=mongolian%20grill&inputtype=textquery&fields=photos,formatted_address,name,opening_hours,rating&locationbias=circle:2000@47.6918452,-122.2226413&key=YOUR_API_KEY
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