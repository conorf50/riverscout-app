package ie.cfarrell.riverscout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.cfarrell.riverscout.models.deviceListModel
import kotlinx.android.synthetic.main.card_device_info.view.*

/*
    Based on this tutorial:
    https://www.youtube.com/watch?v=E3x6pCZutLA

 */

class deviceListAdapter(val context: Context, val allDevices: List<deviceListModel>?) : RecyclerView.Adapter<deviceListAdapter.DeviceListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_device_info, parent, false)
        return DeviceListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return allDevices!!.size
    }

    override fun onBindViewHolder(holder: DeviceListViewHolder, position: Int) {
        val device = allDevices!![position]
        holder.setData(device)

    }


    inner class DeviceListViewHolder(textView: View) : RecyclerView.ViewHolder(textView){
        fun setData(device: deviceListModel?){
            itemView.deviceName.setText(device!!.displayName)
         }

    }

}