package ie.cfarrell.riverscout.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ie.cfarrell.riverscout.R
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ie.cfarrell.riverscout.adapters.deviceListAdapter
import ie.cfarrell.riverscout.interfaces.GetDeviceData
import ie.cfarrell.riverscout.interfaces.GetIEDeviceListService
import ie.cfarrell.riverscout.interfaces.RetrofitClientInstance
import ie.cfarrell.riverscout.models.deviceDataModel
import kotlinx.android.synthetic.main.activity_list.*
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
        toast("device NAME" + gpsLat)
        // gauge_name






        // Invoke the Retrofit instance here
        // see https://www.youtube.com/watch?v=FW7sY7M_E8k for details

        val service = RetrofitClientInstance.retrofitInstance?.create(GetDeviceData::class.java)
        val results : Call<List<deviceDataModel>>?
        // store the results of this in a variable

        results = service?.getDeviceData() // '?' because this API call may return nothing it may be null


        // put the network operation in a seperate thread. Use the question mark to alert the Kotlin compiler that this may return null

        results?.enqueue(object : Callback<List<deviceDataModel>> {
            // we get back a list of deviceList models
            override fun onResponse(call: Call<List<deviceDataModel>>, response: Response<List<deviceDataModel>>) {

                //'response' contains the parsed JSON
                var allDevicesList = response.body()
                //Toast.makeText(applicationContext,"Found " + allDevicesList!!.size.toString(), Toast.LENGTH_LONG).show()
                // replace the adapter with the one from placemark
//                val adapter = deviceListAdapter(allDevicesList, this)
//
//
//                allDevicesView.layoutManager = layoutManager
//                allDevicesView.adapter = adapter


            }

            override fun onFailure(call: Call<List<deviceDataModel>>, t: Throwable) {
                // using applicationContext instead of 'this' based on advice from video above
                Toast.makeText( this@GaugeViewActivity, "Error fetching devices", Toast.LENGTH_LONG).show()
                // todo show a nice card view or dialog box with the error
            }

        })







    }





}