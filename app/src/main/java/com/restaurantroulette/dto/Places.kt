package com.restaurantroulette.dto

import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName

lateinit var address: String;
lateinit var name: String;
var openBool: Boolean = false;
lateinit var photos: JsonArray;
var rating: Float? = null;

data class Places(@SerializedName("formatted_address") var Address : String,
                  @SerializedName("name") var Name : String,
                  @SerializedName("open_now") var OpenBool : Boolean,
                  @SerializedName("photos") var Photos : JsonArray,
                  @SerializedName("rating") var Rating : Float

) {
    init {
        address = Address;
        name = Name;
        openBool = OpenBool;
        photos = Photos;
        rating = Rating;
        }
}