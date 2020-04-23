package com.restaurantroulette.service


import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.restaurantroulette.MainActivity
import com.restaurantroulette.R
import com.restaurantroulette.RetrofitClientInstance
import com.restaurantroulette.dao.iPlacesDAO
import com.restaurantroulette.ui.main.ResultsFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceService {

    fun fetchPlace(input : String) : JsonObject? {

        var resultsFragment: ResultsFragment = ResultsFragment.newInstance()
        val envVar : String? = System.getenv("RR_API_KEY")
        var _place: JsonObject? = JsonObject()
        var call: Call<JsonObject>? = RetrofitClientInstance.retrofitInstance?.create(iPlacesDAO::class.java)?.getPlacesResults(input, "textquery", "photos,formatted_address,name,opening_hours,rating", null, envVar)

        println("Request: \n" + call)
        call?.enqueue(object: Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                println("We failed to get the places \n" + t)
            }

            override fun onResponse(
                call: Call<JsonObject>,
                response: Response<JsonObject>
            ) {
                _place = response.body()
            }
        })
        return _place
    }
}