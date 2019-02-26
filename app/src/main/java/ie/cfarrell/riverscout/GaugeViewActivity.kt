package ie.cfarrell.riverscout

import android.os.Bundle
import android.app.Activity

import kotlinx.android.synthetic.main.activity_gauge_view.*

class GaugeViewActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gauge_view)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
