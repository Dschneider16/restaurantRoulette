package com.restaurantroulette.dao

import com.restaurantroulette.dto.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ICountryDAO {

    @GET("/api/countries")
    fun getAllCountries(): Call<ArrayList<Country>>

    @GET("/api/countries")
    fun getCountry(@Query("Country_Name") countryName : String) : Call<ArrayList<Country>>
}