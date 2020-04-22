package com.restaurantroulette.dao

import com.google.gson.JsonObject
import com.restaurantroulette.dto.Country
import com.restaurantroulette.dto.Places
import com.restaurantroulette.dto.PlacesRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.POST
import java.util.*

interface iPlacesDAO {

    @GET("findplacefromtext/json")
    fun getPlacesResults(
        @Query("input") input: String,
        @Query("inputtype") inputtype: String,
        @Query("fields") fields: String,
        @Query("locationbias") locationbias: Map<String, String>?,
        @Query("key") key: String
    ) : Call<Object>

}