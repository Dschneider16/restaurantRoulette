package com.restaurantroulette.dto

import com.google.gson.annotations.SerializedName

class RestaurantCoordinates(@SerializedName("lat") var latitude : String, @SerializedName("lng") var longitude : String) {
    override fun toString(): String {
        return "$latitude, $longitude"
    }
}