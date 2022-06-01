package com.prueba.arquitecturas_android.model

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

        @GET("getOffers/")
        fun getCoupons(): Call<JsonObject>

}