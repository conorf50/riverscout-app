package ie.cfarrell.riverscout.interfaces

import ie.cfarrell.riverscout.models.favGaugesModel

interface FavsStore {
    fun findFavs(): List<favGaugesModel>

}