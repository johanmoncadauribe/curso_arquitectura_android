package com.prueba.arquitecturas_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.prueba.arquitecturas_android.databinding.ActivityMainBinding
import com.prueba.arquitecturas_android.model.ApiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvCoupons: RecyclerView
    //val rvCoupons: RecyclerView = findViewById(R.id.rvCoupons)
    var coupons = ArrayList<Coupon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        UpdateView()
        controller()
    }

    fun UpdateView (){
        rvCoupons=binding.rvCoupons

        rvCoupons.layoutManager= LinearLayoutManager(this)
        //rvCoupons.layoutManager = LinearLayoutManager(this)
    }

    fun controller(){
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
                rvCoupons.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
            }
        })
    }
}