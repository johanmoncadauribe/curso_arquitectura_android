package com.prueba.arquitecturas_android.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponsRepositoryImpl(): CouponsRepository {

    //lista mutable
    private var coupons = MutableLiveData<List<Coupon>>()

    //toda la logica de codigo
    override fun getCouponsAPI() {

    }

    override fun callCoupunsAPI(){
        var coupons = ArrayList<Coupon>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message.toString())
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                Log.e("response",response.body().toString())
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    Log.e("responseCoupon",coupon.toString())
                    coupons.add(coupon)
                }
                println("\n\n\n\n\n")
                Log.e("Arraycoupons",coupons.toString())
            }
        })
    }
}