package ie.cfarrell.riverscout.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ie.cfarrell.riverscout.R
import android.widget.Toast
import ie.cfarrell.riverscout.interfaces.GetDeviceReadingsService
import ie.cfarrell.riverscout.interfaces.RetrofitClientInstance
import ie.cfarrell.riverscout.models.deviceDataModel
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GaugeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gauge_view)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val extras = intent.extras

        val deviceName = extras.getString("deviceName")
        val gpsLat= extras.getString("gpsLat")
        val gpsLong = extras.getString("gpsLong")
        val deviceID = extras.getString("deviceID")

        val gaugeNameView : TextView = findViewById(R.id.gauge_name)
        gaugeNameView.setText(deviceName)

        val latLngTextView : TextView = findViewById(R.id.location_textview)
        latLngTextView.setText(gpsLong + "," + gpsLat)
        // gauge_name






        // Invoke the Retrofit instance here
        // see https://www.youtube.com/watch?v=FW7sY7M_E8k for details

        val service = RetrofitClientInstance.retrofitInstance?.create(GetDeviceReadingsService::class.java)
        val results : Call<List<deviceDataModel>>?
        // store the results of this in a variable

        results = service?.getDeviceData() // '?' because this API call may return nothing it may be null


        // put the network operation in a seperate thread. Use the question mark to alert the Kotlin compiler that this may return null

        results?.enqueue(object : Callback<List<deviceDataModel>> {
            // we get back a list of deviceList models
            override fun onResponse(call: Call<List<deviceDataModel>>, response: Response<List<deviceDataModel>>) {

                //'response' contains the parsed JSON
                var allDevicesList = response.body()


            }

            override fun onFailure(call: Call<List<deviceDataModel>>, t: Throwable) {
                // using applicationContext instead of 'this' based on advice from video above
                Toast.makeText( this@GaugeViewActivity, "Error fetching devices", Toast.LENGTH_LONG).show()
                // todo show a nice card view or dialog box with the error
            }

        })







    }





}