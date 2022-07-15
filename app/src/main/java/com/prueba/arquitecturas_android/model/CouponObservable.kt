package com.prueba.arquitecturas_android.model

//la clse va a heredar de BaseObservable
class CouponObservable{

    private var couponsRepository: CouponsRepository = CouponsRepositoryImpl()

    fun callCoupons(){
        couponsRepository.getCouponsAPI()
    }

}


