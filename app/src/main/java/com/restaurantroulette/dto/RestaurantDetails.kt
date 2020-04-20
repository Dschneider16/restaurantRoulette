package com.restaurantroulette.dto

import com.google.gson.annotations.SerializedName

data class RestaurantDetails(@SerializedName("phone") var phoneNumber : String, @SerializedName("price") var priceRating : Int) {
    override fun toString(): String {
        return "$phoneNumber, $priceRating"
    }
}