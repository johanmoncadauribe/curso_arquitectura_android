package com.prueba.arquitecturas_android.presenter

import com.prueba.arquitecturas_android.model.Coupon

interface CouponPresenter {
    //vista
    fun showCoupons(coupons: ArrayList<Coupon>)
    //interactor
    fun getCoupons()

}