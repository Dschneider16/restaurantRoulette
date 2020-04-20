package com.restaurantroulette.dto

import com.google.gson.annotations.SerializedName
import com.restaurantroulette.dto.City

data class RestaurantAddress(var address : String, var city : String, var state : String, @SerializedName("postal_code") var postalCode : Int) {
    override fun toString(): String {
        return "$address, $city, $state, $postalCode"
    }
}