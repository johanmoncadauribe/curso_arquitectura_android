package com.prueba.arquitecturas_android.presenter

import com.prueba.arquitecturas_android.model.Coupon
import com.prueba.arquitecturas_android.model.CouponsInteractor
import com.prueba.arquitecturas_android.model.CouponsInteractorImp
import com.prueba.arquitecturas_android.view.CouponView

class CouponsPresenterInpu (var couponView: CouponView): CouponPresenter{

    //instanciamos clase padre couponsinteractor y igualamos a clase hija couponsinteractosimp
    private var couponInteractor: CouponsInteractor =CouponsInteractorImp(this)

    override fun showCoupons(coupons: ArrayList<Coupon>) {
        couponView.showCoupons(coupons)
    }

    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }

}