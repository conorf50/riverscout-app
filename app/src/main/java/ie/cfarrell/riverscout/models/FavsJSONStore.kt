package ie.cfarrell.riverscout.models

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import ie.cfarrell.riverscout.interfaces.FavsStore
import org.jetbrains.anko.AnkoLogger
import org.cfarrell.hillfort.helpers.*
import java.util.*

val JSON_FILE = "favourites.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<favGaugesModel>>() {}.type

class FavsJSONStore : FavsStore, AnkoLogger {


  val context: Context
  var favouriteGauges= mutableListOf<favGaugesModel>()

  constructor (context: Context) {
    this.context = context
    if (exists(context, JSON_FILE)) {
      deserialize()
    }
  }



  private fun serialize() {
    val jsonString = gsonBuilder.toJson(favouriteGauges, listType)
    write(context, JSON_FILE, jsonString)
  }

  private fun deserialize() {
    val jsonString = read(context, JSON_FILE)
    favouriteGauges = Gson().fromJson(jsonString, listType)
  }


    override fun findFavs():List<favGaugesModel> {
        serialize() // update the favourites first
        //val favHillfort: HillfortModel? = hillforts.find { it.visitedFlag == true }
        return favouriteGauges
    }

}
