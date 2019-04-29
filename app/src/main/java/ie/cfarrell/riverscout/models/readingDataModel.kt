package ie.cfarrell.riverscout.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/*
    Special thanks to Brandan Jones' tutorial 'Use Retrofit to parse JSON in Kotlin Android app'
    https://www.youtube.com/watch?v=FW7sY7M_E8k

sample reading for device
[
  {
    "_id": "5cbcdbb3f78df1113f02fd3d",
    "deviceUID": "4D413D",
    "rawHexData": "0000aa4125",
    "waterLevel": {
      "$numberDecimal": "37"
    },
    "waterTemp": {
      "$numberDecimal": "21.2500"
    },
    "timestamp": "2019-04-21T21:08:03.000Z",
    "__v": 0
  },
  {
    "_id": "5cbcdbf6f78df1113f02fd3e",
    "deviceUID": "4D413D",
    "rawHexData": "1f85a74125",
    "waterLevel": {
      "$numberDecimal": "37"
    },
    "waterTemp": {
      "$numberDecimal": "20.9400"
    },
    "timestamp": "2019-04-21T21:09:09.000Z",
    "__v": 0
  }
]



 */
@Parcelize
data class readingDataModel (var _id :String,
                             var deviceUID: String,
                             var waterLevel : WaterLevel,
                             var rawHexData: String,
                             var waterTemp :WaterTemp,
                             var timestamp : String) : Parcelable


@Parcelize
data class  WaterLevel (
    var NumberDecimal : String
) : Parcelable

@Parcelize
data class  WaterTemp (
    var NumberDecimal : String
) : Parcelable