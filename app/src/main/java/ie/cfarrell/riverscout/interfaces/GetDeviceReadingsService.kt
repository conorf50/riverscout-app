package ie.cfarrell.riverscout.interfaces

import ie.cfarrell.riverscout.models.readingDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDeviceReadingsService {

    // get retrofit to call the model and make the request

    // call our API route which will return the specified data
    // we need to specify certain parameters
    // https://stackoverflow.com/questions/49293354/how-to-pass-get-parameters-to-retrofit-request
    @GET("api/getReadingsForDeviceID?deviceID=4D413D&timestampGt=2018-09-09T14%3A00%3A00Z&timestampLt=2019-09-09T00%3A00%3A00Z")
    fun getDeviceData() : Call<List<readingDataModel>>


}