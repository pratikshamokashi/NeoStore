package com.example.neostoreapp.ui.address

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.mycartlisting.MyCartAdapter

class AddressListAdapter( private var aList:MutableList<AddressEntity>,var context: Context):BaseAdapter() {

    fun addAdress(address:List<AddressEntity>) {
        Log.d("tag", "inaddress")
        aList.clear()
        aList.addAll(address)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val viewHolder:MyViewHolder
        val view = LayoutInflater.from(p2?.context).inflate(R.layout.address_row_layout, p2, false)
        viewHolder= MyViewHolder(view)
        val adsList =aList[position]
        Log.d("tag","ads:"+adsList.address)
        viewHolder.addressView.text=String.format("%s %s %s %s %s %s",adsList.address,adsList.city1,adsList.city2,adsList.state,adsList.country,adsList.zipcode)
        return view
        }
    override fun getItem(p0: Int): Any {
        return aList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return aList.size
    }
    inner class MyViewHolder(itemView: View)
    {
        var addressView: TextView = itemView.findViewById<View>(R.id.tv_address_list) as TextView
    }
}



