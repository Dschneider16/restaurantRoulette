package com.restaurantroulette.service

import androidx.lifecycle.MutableLiveData
import com.restaurantroulette.dto.City

class CityService {

    fun fetchCities(cityName : String) : MutableLiveData<ArrayList<City>> {

        return MutableLiveData<ArrayList<City>>()
    }
}