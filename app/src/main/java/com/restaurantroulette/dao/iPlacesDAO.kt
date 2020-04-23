package com.restaurantroulette.dao

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


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