package com.restaurantroulette.dto

import com.google.gson.annotations.SerializedName

data class City(@SerializedName("cities") var name : String) {
    override fun toString(): String {
        return name
    }
}