package com.prueba.arquitecturas_android.model

import com.prueba.arquitecturas_android.presenter.CouponPresenter

class CouponsInteractorImp(var couponPresenter: CouponPresenter): CouponsInteractor {

    private var couponsRepository: CouponsRepository= CouponsRepositoryImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponsRepository.getCouponsAPI()
    }

}