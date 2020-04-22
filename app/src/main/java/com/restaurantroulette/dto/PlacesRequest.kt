package com.restaurantroulette.dto

import com.google.gson.JsonArray
import java.util.*

private lateinit var input: String
private lateinit var inputtype: String
private lateinit var fields: ArrayList<String>
private lateinit var locationbias: Map<String, String>

//var request: MutableMap<String, Any> = mutableMapOf()

data class PlacesRequest(val Input: String, val Inputtype: String, val Fields: ArrayList<String>, val Locationbias: Map<String, String>? = null) {
    init {
        input = Input
        inputtype = Inputtype
        fields = Fields
        if (Locationbias != null){
        locationbias = Locationbias
        }
    }
    fun getRequest(): PlacesRequest
    {
        return this
    }
}