package ie.cfarrell.riverscout.interfaces

import ie.cfarrell.riverscout.models.deviceDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDeviceReadingsService {

    // get retrofit to call the model and make the request

    // call our API route which will return the specified data
    // we need to specify certain parameters
    // https://stackoverflow.com/questions/49293354/how-to-pass-get-parameters-to-retrofit-request
    @GET("api/getInfoForDeviceID")
    fun getDeviceData() : Call<List<deviceDataModel>>


}