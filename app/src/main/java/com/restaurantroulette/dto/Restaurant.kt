package com.restaurantroulette.dto

data class Restaurant(var id : Int, var name : String, var address : String, var state : String,
                 var city : String, var area : String, var postal_code : String, var country : String, var phone : String,
                 var lat : Double, var lng : Double, var price : Int, var reserve_url : String, var mobile_reserve_url : String,
                 var image_url : String) {
    override fun toString() : String{
        return name;
    }
}