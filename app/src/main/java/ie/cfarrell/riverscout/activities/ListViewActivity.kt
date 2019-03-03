package ie.cfarrell.riverscout.activities

import android.os.Bundle
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import ie.cfarrell.riverscout.R

import kotlinx.android.synthetic.main.activity_list.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        // display a back button in the app bar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
