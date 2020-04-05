package com.restaurantroulette.dto

data class Restaurant(var id : Int, var name : String) {
    override fun toString(): String {
        return name
    }
}