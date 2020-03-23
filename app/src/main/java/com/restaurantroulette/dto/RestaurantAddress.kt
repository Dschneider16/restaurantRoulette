package com.restaurantroulette.dto

import com.google.gson.annotations.SerializedName

data class RestaurantAddress(var address : String) {
    override fun toString(): String {
        return address
    }
}