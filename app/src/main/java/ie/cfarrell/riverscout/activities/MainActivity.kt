package ie.cfarrell.riverscout.activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import ie.cfarrell.riverscout.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.homepage.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        val imageButtonList = findViewById<ImageButton>(R.id.buttonViewRivers)
        imageButtonList?.setOnClickListener {
            //Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
            //startActivityForResult(ListViewActivity)
            val intent = Intent(this, ListViewActivity::class.java)
            startActivityForResult(intent, 0)
        }


        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_favourites -> {
                val intent = Intent(this, FavouritesActivity::class.java)
                startActivityForResult(intent, 0)

            }
            R.id.nav_map -> {
                //val intent = Intent(this, GaugeViewActivity::class.java)
                //startActivityForResult(intent, 0)
                Toast.makeText(this, "Feature only available in Riverscout Premium", Toast.LENGTH_SHORT).show()

            }
            R.id.nav_list -> {

                val intent = Intent(this, ListViewActivity::class.java)
                startActivityForResult(intent, 0)
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
