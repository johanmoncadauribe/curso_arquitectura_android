package com.prueba.arquitecturas_android.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prueba.arquitecturas_android.model.Coupon
import com.prueba.arquitecturas_android.databinding.ActivityCouponDetailBinding
import com.squareup.picasso.Picasso

class CouponDetailActivity : AppCompatActivity(){

    private var couponSelected : Coupon? = null
    private lateinit var binding: ActivityCouponDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCouponDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        couponSelected = intent.getSerializableExtra("COUPON") as Coupon
        updateView()
        updateImage()
        eventButton()

    }

    fun updateView(){
        binding.tvTitleDetail.text=couponSelected?.title
        binding.tvDescriptionShortDetail.text = couponSelected?.descriptionShort
        binding.tvCategoryDetail.text = couponSelected?.category
        binding.tvDateDetail.text = couponSelected?.endDate
        binding.tvDescriptionDetailData.text = couponSelected?.description
        binding.tvOffertDetailData.text = couponSelected?.offer
        binding.tvWebsiteDetailData.text = couponSelected?.website
        binding.tvDateEndData.text = couponSelected?.endDate
    }

    fun updateImage(){
        Picasso.get().load(couponSelected?.image_url).resize(520, 520).centerCrop().into(binding.imgHeaderDetail)
        Picasso.get().load(couponSelected?.image_url).resize(520, 520).centerCrop().into(binding.imgCouponDetail)
    }

    fun eventButton(){
        binding.btnOpenOffer.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(couponSelected?.url)
            startActivity(openURL)
        }

    }

}


