package ie.cfarrell.riverscout.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/*
    Special thanks to Brandan Jones' tutorial 'Use Retrofit to parse JSON in Kotlin Android app'
    https://www.youtube.com/watch?v=FW7sY7M_E8k

 */

@Parcelize
data class deviceListModel(var _id : String, var displayName : String ) : Parcelable