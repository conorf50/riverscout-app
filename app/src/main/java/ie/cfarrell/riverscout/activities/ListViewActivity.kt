package ie.cfarrell.riverscout.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.cfarrell.riverscout.interfaces.GetIEDeviceListService
import ie.cfarrell.riverscout.interfaces.GetUKDeviceListService

import ie.cfarrell.riverscout.R
import ie.cfarrell.riverscout.adapters.DeviceListListener
import ie.cfarrell.riverscout.adapters.deviceListAdapter
import ie.cfarrell.riverscout.interfaces.RetrofitClientInstance
import ie.cfarrell.riverscout.models.deviceDataModel
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.card_favourite.*

import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewActivity : AppCompatActivity(), DeviceListListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        // display a back button in the app bar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val countryCode = intent.getStringExtra("countryCode")
        toast("Country code" + countryCode )
        // Set the RecyclerView layout manager
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL


        // Invoke the Retrofit instance here
        // see https://www.youtube.com/watch?v=FW7sY7M_E8k for details
        val service = RetrofitClientInstance.retrofitInstance?.create(GetIEDeviceListService::class.java)

        // store the results of this in a variable
        val results = service?.getAllDevices() // '?' because this API call may return nothing it may be null
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
                val layoutManager = LinearLayoutManager(this@ListViewActivity)
                allDevicesView.layoutManager = layoutManager
                allDevicesView.adapter = deviceListAdapter(allDevicesList, this@ListViewActivity)

            }

            override fun onFailure(call: Call<List<deviceDataModel>>, t: Throwable) {
                // using applicationContext instead of 'this' based on advice from video above
                Toast.makeText(this@ListViewActivity, "Error fetching devices", Toast.LENGTH_LONG).show()
                // todo show a nice card view or dialog box with the error
            }

        })


    }


    override fun onCardClick(deviceList: deviceDataModel) {
        // since we want to pass both the device name and ID to the data view activity
        //  we need to put them into a Bundle
        // see https://stackoverflow.com/questions/8452526/android-can-i-use-putextra-to-pass-multiple-values
        val deviceInfo = Bundle()

        deviceInfo.putString("deviceName", deviceList.displayName)
        deviceInfo.putString("deviceID", deviceList._id)
        deviceInfo.putString("gpsLat", deviceList.gpsLat.toString())
        deviceInfo.putString("gpsLong", deviceList.gpsLong.toString())
        startActivityForResult(intentFor<GaugeViewActivity>().putExtras(deviceInfo), 0)

    }

}
