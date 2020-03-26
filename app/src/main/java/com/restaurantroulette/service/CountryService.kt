package com.restaurantroulette.service

import androidx.lifecycle.MutableLiveData
import com.restaurantroulette.dto.Country

class CountryService {

    fun fetchCountries(countryName : String) : MutableLiveData<ArrayList<Country>> {

        return MutableLiveData<ArrayList<Country>>()
    }
}