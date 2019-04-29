package ie.cfarrell.riverscout.interfaces

import ie.cfarrell.riverscout.models.deviceDataModel
import retrofit2.Call
import retrofit2.http.GET

interface GetUKDeviceListService {

    // get retrofit to call the model and make the request

    // call our API route which will return a list of the specified models
    @GET("/api/getDevicesInCountry?countryCode=UK")
    fun getAllDevices() : Call<List<deviceDataModel>>

}