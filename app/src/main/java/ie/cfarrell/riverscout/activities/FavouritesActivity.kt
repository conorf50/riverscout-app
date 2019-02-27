package ie.cfarrell.riverscout.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.cfarrell.riverscout.R

class FavouritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)
        // display a back button in the app bar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
