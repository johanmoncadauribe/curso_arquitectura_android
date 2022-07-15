package com.prueba.arquitecturas_android.viewModel

import androidx.lifecycle.ViewModel
import com.prueba.arquitecturas_android.model.CouponObservable

//hereda de view model
class CouponViewModel: ViewModel(){

    private var couponObservable: CouponObservable = CouponObservable()

    fun callCoupons(){

    }
}