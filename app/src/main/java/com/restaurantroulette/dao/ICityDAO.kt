package com.restaurantroulette.dao

import com.restaurantroulette.dto.City
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ICityDAO {

    @GET("/api/cities/")
    fun getAllCities(): Call<ArrayList<City>>

    @GET("/api/cities")
    fun getCity(@Query("City_Name") cityName : String) : Call<ArrayList<City>>
}