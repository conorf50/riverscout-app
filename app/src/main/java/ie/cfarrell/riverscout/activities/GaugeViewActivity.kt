package ie.cfarrell.riverscout.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ie.cfarrell.riverscout.R
import android.widget.Toast
import org.jetbrains.anko.toast

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
    }





}