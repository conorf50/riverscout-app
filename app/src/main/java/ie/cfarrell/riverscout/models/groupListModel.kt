package ie.cfarrell.riverscout.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/*
    Special thanks to Brandan Jones' tutorial 'Use Retrofit to parse JSON in Kotlin Android app'
    https://www.youtube.com/watch?v=FW7sY7M_E8k

 */

/*
    Sample API output
    [
  {
    "_id": "5cc05199601e5606f9a7bcbe",
    "groupLat": {
      "$numberDecimal": "52.4542"
    },
    "groupLong": {
      "$numberDecimal": "-7.3453"
    },
    "groupName": "Unit Test Group #1",
    "countryCode": "IE",
    "__v": 0
  },
  {
    "_id": "5cc05199601e5606f9a7bcc1",
    "groupLat": {
      "$numberDecimal": "53.9932"
    },
    "groupLong": {
      "$numberDecimal": "-7.6453"
    },
    "groupName": "Unit Test Group #4",
    "countryCode": "IE",
    "__v": 0
  },
  {
    "_id": "5cc05199601e5606f9a7bcc2",
    "groupLat": {
      "$numberDecimal": "51.4541"
    },
    "groupLong": {
      "$numberDecimal": "-6.9989"
    },
    "groupName": "Unit Test Group #5",
    "countryCode": "IE",
    "__v": 0
  }
]

 */
@Parcelize
data class groupListModel (
    var _id :String,
    var groupLat: GroupLat,
    var groupLong : GroupLong,
    var groupName :String,
    var countryCode : String) : Parcelable


@Parcelize
data class  GroupLat (
    var `$NumberDecimal` : String
) : Parcelable

@Parcelize
data class  GroupLong (
    var `$NumberDecimal` : String
) : Parcelable