package com.restaurantroulette.service

import androidx.lifecycle.MutableLiveData
import com.restaurantroulette.RetrofitClientInstance
import com.restaurantroulette.dao.ICountryDAO
import com.restaurantroulette.dto.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryService {

    fun fetchCountries(countryName : String) : MutableLiveData<ArrayList<Country>> {

        var _countries = MutableLiveData<ArrayList<Country>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(ICountryDAO::class.java)
        val call = service?.getAllCountries()
        call?.enqueue(object : Callback<ArrayList<Country>> {
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<ArrayList<Country>>, t: Throwable) {
                print("Error at Retrofit thread enqueue in Country Service.")
            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(
                call: Call<ArrayList<Country>>,
                response: Response<ArrayList<Country>>
            ) {
                _countries.value = response.body()
            }

        })



        return _countries
    }
}