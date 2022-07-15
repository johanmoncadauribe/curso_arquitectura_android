package com.prueba.arquitecturas_android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prueba.arquitecturas_android.model.Coupon
import com.prueba.arquitecturas_android.R
import com.prueba.arquitecturas_android.databinding.ActivityMainBinding
import java.lang.Exception

//implementamos la clase couponView
class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvCoupons: RecyclerView
    //val rvCoupons: RecyclerView = findViewById(R.id.rvCoupons)



    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        MainActivity es clase hija de CouponView, por lo que son de la misma naturaleza y se puede mandar
        por parametro couponView como this.
         */
        UpdateView()
    }

    fun UpdateView (){
        rvCoupons=binding.rvCoupons
        rvCoupons.layoutManager= LinearLayoutManager(this)
        //rvCoupons.layoutManager = LinearLayoutManager(this)
    }



}