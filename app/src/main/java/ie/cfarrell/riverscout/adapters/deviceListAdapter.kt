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
import ie.cfarrell.riverscout.models.deviceListModel
import kotlinx.android.synthetic.main.card_device_info.view.*

/*
    Based on this tutorial:
    https://www.youtube.com/watch?v=E3x6pCZutLA

 */


interface DeviceListListener {
    fun onCardClick(devlceList: deviceListModel)
}

class deviceListAdapter constructor(val allDevices: List<deviceListModel>?,
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

        fun bind(device: deviceListModel,  listener : DeviceListListener) {
            itemView.deviceName.text = device.displayName
            itemView.setOnClickListener { listener.onCardClick(device) }

        }
    }
}







//class deviceListAdapter(val context: Context, val allDevices: List<deviceListModel>?) : RecyclerView.Adapter<deviceListAdapter.DeviceListViewHolder>(){
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceListViewHolder {
//        val view = LayoutInflater.from(context).inflate(R.layout.card_device_info, parent, false)
//        return DeviceListViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return allDevices!!.size
//    }
//
//    override fun onBindViewHolder(holder: DeviceListViewHolder, position: Int) {
//        val device = allDevices!![position]
//        holder.setData(device)
//
//    }
//
//
//    inner class DeviceListViewHolder(textView: View) : RecyclerView.ViewHolder(textView){
//
//        // define the current device
//        var currentDevice :deviceListModel? = null
//        var currentPos : Int = 0
//
//
//        init {
//            itemView.setOnClickListener{
//                Toast.makeText(context, currentDevice.toString(), Toast.LENGTH_SHORT).show()
//                val deviceName = currentDevice?.displayName
//                val deviceID = currentDevice?._id
//
//               val intent = Intent(itemView.context, GaugeViewActivity::class.java)
//               // intent.putExtra(deviceID, 0)
//                context.startActivity(intent,null)
//
//                //val intent = Intent(itemView.context, ListViewActivity::class.java)
//                //startActivityForResult(intent)
//                //startActivityForResult(GaugeViewActivity, context, 0)
//            }
//        }
//
//        fun setData(device: deviceListModel?){
//            itemView.deviceName.setText(device!!.displayName)
//            // set the current device to the passed in device
//            this.currentDevice = device
//            this.currentPos = position
//         }
//
//    }
//
