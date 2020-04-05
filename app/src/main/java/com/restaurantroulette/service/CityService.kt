package com.restaurantroulette.service

import androidx.lifecycle.MutableLiveData
import com.restaurantroulette.RetrofitClientInstance
import com.restaurantroulette.dao.ICityDAO
import com.restaurantroulette.dto.City
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityService {

    fun fetchCities(cityName : String) : MutableLiveData<ArrayList<City>> {

        var _cities = MutableLiveData<ArrayList<City>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(ICityDAO::class.java)
        val call = service?.getAllCities()
        call?.enqueue(object : Callback<ArrayList<City>> {
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<ArrayList<City>>, t: Throwable) {
                val j = 1 + 1
                val i = 1 + 1
            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(
                call: Call<ArrayList<City>>,
                response: Response<ArrayList<City>>
            ) {
                _cities.value = response.body()
            }

        })

        return _cities
    }
}