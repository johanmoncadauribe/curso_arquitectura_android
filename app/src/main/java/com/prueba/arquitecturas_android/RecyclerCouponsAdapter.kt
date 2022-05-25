package com.prueba.arquitecturas_android

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


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
            this.coupon = coupon
            Picasso.get().load(coupon.image_url).resize(520, 520).centerCrop().into(imgCoupon)
            tvTitle.setText(coupon.title)
            tvDescriptionShort.setText(coupon.descriptionShort)
            tvCategory.setText(coupon.category)
            tvDate.setText(coupon.endDate)

        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
            Log.i("CLICK Coupon: ", coupon?.title.toString())
            val context = v?.context
            val showPhotoIntent = Intent(context, CouponDetailActivity::class.java)
            showPhotoIntent.putExtra("COUPON", coupon)
            context?.startActivity(showPhotoIntent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardCouponHolder {
        TODO("Not yet implemented")
        var view: View = LayoutInflater.from(parent!!.context).inflate(resource, parent, false)
        return CardCouponHolder(view)
    }

    override fun onBindViewHolder(holder: CardCouponHolder, position: Int) {
        TODO("Not yet implemented")
        var coupon = coupons.get(position)
        holder.setDataCard(coupon)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return coupons.size
    }
}