package com.restaurantroulette.dto

import com.google.gson.annotations.SerializedName

data class Country(@SerializedName("countries") var code : String, var name : String = "") {
    init {
        when (code) {
            "AW" -> {
                name = "Aruba"
            }
            "CA" -> {
                name = "Canada"
            }
            "CN" -> {
                name = "China"
            }
            "GP" -> {
                name = "Guadeloupe"
            }
            "HK" -> {
                name = "Hong Kong"
            }
            "KN" -> {
                name = "Saint Kitts and Nevis"
            }
            "KY" -> {
                name = "Cayman Islands"
            }
            "MO" -> {
                name = "Macao"
            }
            "MX" -> {
                name = "Mexico"
            }
            "MY" -> {
                name = "Malaysia"
            }
            "SV" -> {
                name = "El Salvador"
            }
            "US" -> {
                name = "United States"
            }
            "VI" -> {
                name = "Virgin Islands"
            }
        }
    }

    override fun toString(): String {
        return name
    }
}