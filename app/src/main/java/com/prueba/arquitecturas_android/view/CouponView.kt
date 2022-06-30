package com.prueba.arquitecturas_android.view

import com.prueba.arquitecturas_android.model.Coupon

    interface CouponView{
        fun getCoupons()

        fun showCoupons(coupons: ArrayList<Coupon>)

    }


