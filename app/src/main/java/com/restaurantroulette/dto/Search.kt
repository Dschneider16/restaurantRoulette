package com.restaurantroulette.dto

data class Search(var restaurantID : Int, var price : Int, var name : String, var address : String, var state : String,
                  var city : String, var zip : Int, var country : String, var page : Int, var per_page : Int) {
}