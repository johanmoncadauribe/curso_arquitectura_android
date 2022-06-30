package com.prueba.arquitecturas_android.view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prueba.arquitecturas_android.model.Coupon
import com.prueba.arquitecturas_android.R
import com.squareup.picasso.Picasso.get


/*
    esta clase que es el adapter de card_coupon extiende de recycler view
 */
class RecyclerCouponsAdapter (var coupons : ArrayList<Coupon>, var resource: Int):  RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    class CardCouponHolder (v: View) : RecyclerView.ViewHolder(v), View.OnClickListener{

        private var coupon: Coupon? = null
        private var imgCoupon: ImageView = v.findViewById(R.id.imgCoupon)
        private var tvTitle: TextView = v.findViewById(R.id.tvTitle)
        private var tvDescriptionShort: TextView = v.findViewById(R.id.tvDescriptionShort)
        private var tvCategory: TextView = v.findViewById(R.id.tvCategory)
        private var tvDate: TextView = v.findViewById(R.id.tvDate)

        init {
            v.setOnClickListener(this)
        }

        fun setDataCard(coupon: Coupon){
            println("\n\n")
            Log.e("setDataCard","${coupon.image_url}")
            this.coupon = coupon
            get().load(coupon.image_url).resize(520, 520).centerCrop().into(imgCoupon)
            tvTitle.setText(coupon.title)
            tvDescriptionShort.setText(coupon.descriptionShort)
            tvCategory.setText(coupon.category)
            tvDate.setText(coupon.endDate)

        }

        override fun onClick(v: View?) {
            Log.i("CLICK Coupon: ", coupon?.title.toString())
            val context = v?.context
            val showPhotoIntent = Intent(context, CouponDetailActivity::class.java)
            showPhotoIntent.putExtra("COUPON", coupon)
            context?.startActivity(showPhotoIntent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardCouponHolder {
        Log.e("RECYCLERitemCreate","tamaño")
        val view: View = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return CardCouponHolder(view)
    }

    override fun onBindViewHolder(holder: CardCouponHolder, position: Int) {
        Log.e("RECYCLERonBind","tamaño  "+coupons.toString())
        holder.setDataCard(coupons[position])
    }

    override fun getItemCount(): Int {
        Log.e("RECYCLERitem","tamaño"+coupons.size)
        return coupons.size
    }
}