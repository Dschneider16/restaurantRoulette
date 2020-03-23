package com.restaurantroulette.dto

data class RestaurantAddress(var address : String) {
    override fun toString(): String {
        return address
    }
}