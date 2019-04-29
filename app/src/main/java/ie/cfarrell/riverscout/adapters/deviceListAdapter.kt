package ie.cfarrell.riverscout.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ie.cfarrell.riverscout.R
import ie.cfarrell.riverscout.activities.GaugeViewActivity
import ie.cfarrell.riverscout.models.deviceDataModel
import kotlinx.android.synthetic.main.card_device_info.view.*

/*
    Based on this tutorial:
    https://www.youtube.com/watch?v=E3x6pCZutLA

 */


interface DeviceListListener {
    fun onCardClick(devlceList: deviceDataModel)
}

class deviceListAdapter constructor(val allDevices: List<deviceDataModel>?,
                                   private val listener: DeviceListListener) : RecyclerView.Adapter<deviceListAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(LayoutInflater.from(parent?.context).inflate(R.layout.card_device_info, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val device = allDevices!![holder.adapterPosition]
        holder.bind(device, listener)
    }

    override fun getItemCount(): Int = allDevices!!.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(device: deviceDataModel,  listener : DeviceListListener) {
            itemView.deviceName.text = device.displayName
            itemView.setOnClickListener { listener.onCardClick(device) }

        }
    }
}
