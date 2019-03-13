package ie.cfarrell.riverscout.interfaces

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
    Special thanks to Brandan Jones' tutorial 'Use Retrofit to parse JSON in Kotlin Android app'
    https://www.youtube.com/watch?v=FW7sY7M_E8k

    Based on code from here: https://raw.githubusercontent.com/discospiff/PlantPlacesMobile26/master/app/src/main/java/edu/uc/jonesbr/plantplaces/dao/RetrofitClientInstance.java

 */

object RetrofitClientInstance {

    private var retrofit: Retrofit? = null
    private val BASE_URL = "http://18.202.34.190:8080/"

    // create a retrofit instance, only if it has not been created yet.
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit
        }
}