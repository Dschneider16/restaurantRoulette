package com.restaurantroulette.dto

import com.google.gson.annotations.SerializedName

data class Country(@SerializedName("countries") var code : String) {
}