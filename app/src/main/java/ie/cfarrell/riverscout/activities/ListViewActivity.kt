package ie.cfarrell.riverscout.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.cfarrell.riverscout.interfaces.GetDeviceListService
import ie.cfarrell.riverscout.R
import ie.cfarrell.riverscout.deviceListAdapter
import ie.cfarrell.riverscout.interfaces.RetrofitClientInstance
import ie.cfarrell.riverscout.models.deviceListModel

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewActivity : AppCompatActivity() {
    // variables for the recyclerView
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

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
        results?.enqueue(object : Callback<List<deviceListModel>> {
            override fun onResponse(call: Call<List<deviceListModel>>, response: Response<List<deviceListModel>>) {
                //'response' contains the parsed JSON
                val body = response.body()
                Toast.makeText(applicationContext,"Successful", Toast.LENGTH_LONG).show()
                var listSize = body?.size

            }

            override fun onFailure(call: Call<List<deviceListModel>>, t: Throwable) {
                // using applicationContext instead of 'this' based on advice from video above
                Toast.makeText(applicationContext, "Error fetching all devices", Toast.LENGTH_LONG).show()
            }

        })
        // Handle RecyclerView stuff
        // todo pass array of device names into this instead
        var myDataset = arrayOf("Hello", "World", "Conor")
        viewManager = LinearLayoutManager(this)
        viewAdapter = deviceListAdapter(myDataset)

    }

}
