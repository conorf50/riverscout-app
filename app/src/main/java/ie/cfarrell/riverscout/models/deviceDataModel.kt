package ie.cfarrell.riverscout.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/*
    Special thanks to Brandan Jones' tutorial 'Use Retrofit to parse JSON in Kotlin Android app'
    https://www.youtube.com/watch?v=FW7sY7M_E8k

 */


/*
Sample response
{
  "groupIDS": [
    "5cc05199601e5606f9a7bcc1"
  ],
  "_id": "5cc1b518617bf18c97a84398",
  "sigfoxID": "string",
  "EOLDate": "2019-09-09T00:00:00Z",
  "__v": 0,
  "activeStatus": true,
  "countryCode": "IE",
  "deviceHistory": null,
  "displayName": "MAD",
  "downlinkEnabled": true,
  "gpsLat": {
    "$numberDecimal": "0"
  },
  "gpsLong": {
    "$numberDecimal": "0"
  },
  "installDate": "2019-09-09T00:00:00.000Z",
  "replacementDate": "2019-09-09T00:00:00.000Z",
  "reportingFreq": 12
}


 */


// Nested JSON example came from here
//https://discuss.kotlinlang.org/t/retrofit-an-gson-deserialize-a-specific-object-type-based-on-the-value-of-a-field/10440/2





@Parcelize
data class deviceDataModel (var groupIDS :ArrayList<String>,
                            var _id : String,
                            var sigfoxId :String,
                            var EOLDate :String,
                            var _v :String,
                            var activeStatus :Boolean,
                            var countryCode: String,
                            var deviceHistory : String,
                            var displayName :String,
                            var downlinkEnabled : Boolean,
                            var gpsLat: GpsLat, // use the custom model defined below
                            var gpsLong: GpsLong,
                            var installDate : String,
                            var replacementDate : String,
                            var reportingFreq : Int) : Parcelable


@Parcelize
data class GpsLat (var `$NumberDecimal`: String) : Parcelable

@Parcelize
data class GpsLong (var `$NumberDecimal`: String) : Parcelable