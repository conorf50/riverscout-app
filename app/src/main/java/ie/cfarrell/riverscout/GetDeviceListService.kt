package ie.cfarrell.riverscout

import ie.cfarrell.riverscout.models.deviceListModel
import retrofit2.Call
import retrofit2.http.GET

interface GetDeviceListService {

    // get retrofit to call the model and make the request

    // call our API route /devices
    @GET("/api/getAllDevices")
    fun getAllDevices() : Call<List<deviceListModel>>

}