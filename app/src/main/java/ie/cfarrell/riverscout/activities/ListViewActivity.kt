package ie.cfarrell.riverscout.activities

import android.os.Bundle
import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ie.cfarrell.riverscout.GetDeviceListService
import ie.cfarrell.riverscout.R
import ie.cfarrell.riverscout.RetrofitClientInstance
import ie.cfarrell.riverscout.models.deviceListModel

import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        // display a back button in the app bar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        // Invoke the Retrofit instance here
        // see https://www.youtube.com/watch?v=FW7sY7M_E8k for details


        val service = RetrofitClientInstance.retrofitInstance?.create(GetDeviceListService::class.java)
        // store the results of this in a variable
        val results = service?.getAllDevices() // '?' because this API call may return nothing it may be null

        // put the network operation in a seperate thread
        results?.enqueue(object : Callback<deviceListModel> {
            override fun onFailure(call: Call<deviceListModel>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<deviceListModel>, response: Response<deviceListModel>) {
                // using applicationContext instead of 'this' based on advice from video above
                Toast.makeText(applicationContext, "Error fetching all devices", Toast.LENGTH_LONG).show()
            }

        })

    }

}
