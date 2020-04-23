package com.restaurantroulette.service


import com.restaurantroulette.RetrofitClientInstance
import com.restaurantroulette.dao.iPlacesDAO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceService {

    fun fetchPlace(input : String) : Object? {

        var _place: Object? = Object()
        var call: Call<Object>? = RetrofitClientInstance.retrofitInstance?.create(iPlacesDAO::class.java)?.getPlacesResults(input, "textquery", "photos,formatted_address,name,opening_hours,rating", null, "AIzaSyDRWf-bSt6GMqPH5MWIpxF3EIDr9r_InRY")

        println("Request: \n" + call)
        call?.enqueue(object: Callback<Object> {
            override fun onFailure(call: Call<Object>, t: Throwable) {
                println("We failed to get the places \n" + t)
            }

            override fun onResponse(
                call: Call<Object>,
                response: Response<Object>
            ) {
                _place = response.body()
                println(response.body())
            }
        })

        return _place
    }
}