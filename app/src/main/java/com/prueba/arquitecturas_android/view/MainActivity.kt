package com.prueba.arquitecturas_android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.prueba.arquitecturas_android.model.Coupon
import com.prueba.arquitecturas_android.R
import com.prueba.arquitecturas_android.databinding.ActivityMainBinding
import com.prueba.arquitecturas_android.model.ApiAdapter
import com.prueba.arquitecturas_android.presenter.CouponPresenter
import com.prueba.arquitecturas_android.presenter.CouponsPresenterInpu
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

//implementamos la clase couponView
class MainActivity : AppCompatActivity(), CouponView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvCoupons: RecyclerView
    //val rvCoupons: RecyclerView = findViewById(R.id.rvCoupons)

    //instanciamos la clase presenter para realizar la comunicacion con el model
    private var couponPresenter: CouponPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        MainActivity es clase hija de CouponView, por lo que son de la misma naturaleza y se puede mandar
        por parametro couponView como this.
         */
        couponPresenter=CouponsPresenterInpu(this)
        UpdateView()
        getCoupons()
    }

    fun UpdateView (){
        rvCoupons=binding.rvCoupons
        rvCoupons.layoutManager= LinearLayoutManager(this)
        //rvCoupons.layoutManager = LinearLayoutManager(this)
    }


    override fun getCoupons() {
        couponPresenter?.getCoupons()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>) {
        try{
            rvCoupons!!.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
        }catch (e: Exception){
            e.printStackTrace()
            Log.e("MainActivity","exception ShowCoupons   --->>>   "+e.toString())
        }

    }

}