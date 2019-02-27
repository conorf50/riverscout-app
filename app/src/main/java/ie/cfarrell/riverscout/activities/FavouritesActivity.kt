package ie.cfarrell.riverscout.activities

import android.os.Bundle
import android.app.Activity
import ie.cfarrell.riverscout.R

import kotlinx.android.synthetic.main.activity_favourites_.*

class FavouritesActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites_)
        super.setTitle("Favs")
    }

}
