package ie.cfarrell.riverscout

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import ie.cfarrell.riverscout.activities.GaugeViewActivity
import ie.cfarrell.riverscout.activities.ListViewActivity
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

        // define the current device
        var currentDevice :deviceListModel? = null
        var currentPos : Int = 0


        init {
            itemView.setOnClickListener{
                Toast.makeText(context, currentDevice.toString(), Toast.LENGTH_SHORT).show()
                val deviceName = currentDevice?.displayName
                val deviceID = currentDevice?._id

               val intent = Intent(itemView.context, GaugeViewActivity::class.java)
               // intent.putExtra(deviceID, 0)
                context.startActivity(intent,null)

                //val intent = Intent(itemView.context, ListViewActivity::class.java)
                //startActivityForResult(intent)
                //startActivityForResult(GaugeViewActivity, context, 0)
            }
        }

        fun setData(device: deviceListModel?){
            itemView.deviceName.setText(device!!.displayName)
            // set the current device to the passed in device
            this.currentDevice = device
            this.currentPos = position
         }

    }

}