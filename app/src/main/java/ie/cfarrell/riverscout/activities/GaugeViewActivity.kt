package ie.cfarrell.riverscout.activities

import android.os.Bundle
import android.app.Activity
import ie.cfarrell.riverscout.R

class GaugeViewActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gauge_view)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        super.setTitle("View Details")
    }

}
