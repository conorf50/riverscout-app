package ie.cfarrell.riverscout.models
/*
    Special thanks to Brandan Jones' tutorial 'Use Retrofit to parse JSON in Kotlin Android app'
    https://www.youtube.com/watch?v=FW7sY7M_E8k

 */

data class deviceDataModel (var _id :String, var deviceID: String, var waterLevel : String, var waterTemp :String, var timestamp : String){

}