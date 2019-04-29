package ie.cfarrell.riverscout.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/*
    Special thanks to Brandan Jones' tutorial 'Use Retrofit to parse JSON in Kotlin Android app'
    https://www.youtube.com/watch?v=FW7sY7M_E8k

 */


/*
Sample response for a list of devices per country
[
  {
    "groupIDS": [
      "5cc0625fc4504716eb3bd3d7"
    ],
    "_id": "5cc062abc4504716eb3bd3ee",
    "sigfoxID": "4D413D",
    "EOLDate": "2020-02-02T00:00:00Z",
    "__v": 0,
    "activeStatus": true,
    "countryCode": "IE",
    "deviceHistory": null,
    "displayName": "Pycom SiPy",
    "downlinkEnabled": false,
    "gpsLat": {
      "$numberDecimal": "-7.3422"
    },
    "gpsLong": {
      "$numberDecimal": "56.6434"
    },
    "installDate": "2019-02-02T00:00:00.000Z",
    "replacementDate": "2019-07-07T00:00:00.000Z",
    "reportingFreq": 15
  }
]


 */


// Nested JSON example came from here
//https://discuss.kotlinlang.org/t/retrofit-an-gson-deserialize-a-specific-object-type-based-on-the-value-of-a-field/10440/2





    @Parcelize
    data class deviceDataModel (var groupIDS :ArrayList<String>,
                                var _id : String,
                                var sigfoxID :String,
                                var EOLDate :String,
                                var __v :String,
                                var activeStatus :Boolean,
                                var countryCode: String,
                                var deviceHistory : String?,
                                var displayName :String,
                                var downlinkEnabled : Boolean,
                                var gpsLat: Double,
                                var gpsLong: Double,
                                var installDate : String,
                                var replacementDate : String,
                                var reportingFreq : Int) : Parcelable


////@Parcelize
//data class GpsLat (var `$NumberDecimal`: String)
//
//data class GpsLong (var `$NumberDecimal`: String)