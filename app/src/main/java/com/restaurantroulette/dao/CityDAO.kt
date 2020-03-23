package com.restaurantroulette.dao

import com.restaurantroulette.dto.City
import com.restaurantroulette.dto.Country
import com.restaurantroulette.dto.Restaurant
import com.restaurantroulette.dto.Search
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CityDAO {

    @GET("/api/cities")
    fun getAllCities(): Call<ArrayList<City>>

    @GET("/api/countries")
    fun getAllCountries(): Call<ArrayList<Country>>

    @GET("/api/restaurants")
    fun getRestaurants() : Call<Search>

    @GET("/api/restaurants/{id}")
    fun getRestaurantByID(@Path("id") id : Int): Call<Restaurant>
}