package ie.cfarrell.riverscout.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.cfarrell.riverscout.R

class GaugeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gauge_view)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
