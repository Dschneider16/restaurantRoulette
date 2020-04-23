package com.restaurantroulette.dto

import com.google.gson.JsonArray

data class Places(
    var formatted_address: String?,
    var name: String?,
    var open_now: Boolean?,
    var photos: JsonArray?,
    var rating: Float?
)