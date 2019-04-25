package ie.cfarrell.riverscout.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/*
    Special thanks to Brandan Jones' tutorial 'Use Retrofit to parse JSON in Kotlin Android app'
    https://www.youtube.com/watch?v=FW7sY7M_E8k

 */
@Parcelize
data class readingDataModel (var _id :String, var deviceID: String, var waterLevel : String, var waterTemp :String, var timestamp : String) : Parcelable