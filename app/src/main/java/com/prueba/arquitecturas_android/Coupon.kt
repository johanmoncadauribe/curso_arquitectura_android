package com.prueba.arquitecturas_android

import android.util.Log
import com.google.gson.JsonObject
import java.io.Serializable
import java.lang.Exception
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Coupon (couponJson: JsonObject?) : Serializable {

    /*
    variables lateinit  se usa para declariacion mutables que despues de declaradas se les pueda asignar el valor y evitar la comprobacion de nulos
     */
    lateinit var id: String
    lateinit var image_url: String
    lateinit var title: String
    lateinit var descriptionShort: String
    lateinit var category: String
    lateinit var description:String
    lateinit var offer: String
    lateinit var website: String
    lateinit var endDate: String
    lateinit var url: String

    /*
    companion object se usa para declarar variables o metodos (funciones) que sean estaticas en una clase
     */
    companion object {
        private val ID                  = "lmd_id"
        private val IMAGE_URL           = "image_url"
        private val TITLE               = "title"
        private val DESCRIPTION_SHORT   = "offer_text"
        private val CATEGORY            = "categories"
        private val DESCRIPTION         = "description"
        private val OFFER               = "offer"
        private val WEBSITE             = "store"
        private val END_DATE            = "end_date"
        private val URL                 = "url"
    }

    /*
    ejecuta la inicializacion asignando los valores a las variables lateinit
     */
    init {
        try {
            id                  = couponJson?.get(ID).toString()
            image_url           = couponJson?.get(IMAGE_URL).toString()
            title               = couponJson?.get(TITLE).toString()
            descriptionShort    = chunkWords(couponJson?.get(DESCRIPTION_SHORT).toString(), ' ', 5)
            category            = chunkWords(couponJson?.get(CATEGORY).toString(), ',', 1)
            description         = couponJson?.get(DESCRIPTION).toString()
            offer               = couponJson?.get(OFFER).toString()
            website             = couponJson?.get(WEBSITE).toString()
            endDate             = getFormatDate(couponJson?.get(END_DATE).toString())
            url                 = couponJson?.get(URL).toString()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }


    /*
    retorna en formato string el formato de las fechas.
     */
    private fun getFormatDate(dateCoupon:String):String {
        Log.e("getFormatDate",dateCoupon)
//        val format = SimpleDateFormat("yyyy-MM-dd")
//        val dateFormat = SimpleDateFormat("dd MMMM yyyy")
//        try {
//            val parsedDateFormat: Date = format.parse(dateCoupon.toString())
//            val cal = Calendar.getInstance()
//            cal.time = parsedDateFormat
//            return dateFormat.format(cal.time)
//        } catch (e: ParseException) {
//            Log.e("exceptionDate",e.toString())
//            e.printStackTrace()
//            return dateCoupon
//        }
        return dateCoupon
    }

    /*
        Separa la lista de categorias que vienen separadas con una coma
     */
    private fun chunkWords(string: String, delimiter: Char, quantity: Int): String {
        if(string.isNotEmpty()){
            val words = string.split(delimiter)
            var newString: String = ""
            for (i in 0..quantity){
                if(i<words.size) {
                    newString += words.get(i) + " "
                }
            }
            Log.e("returnWords",newString)
            return newString
        }
        Log.e("returnWords","NA")
        return "NA"
    }

    override fun toString(): String {
        return "\nCoupon(id='$id', \n image_url='$image_url', \n title='$title', \n descriptionShort='$descriptionShort', \n category='$category', " +
                "\n description='$description', \n offer='$offer',\n  website='$website', \n endDate='$endDate', \n url='$url')"
    }


}