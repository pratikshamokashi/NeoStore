package com.example.neostoreapp.ui.myorder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neostoreapp.R

class MyOrderAdapter(context: Context, private var list: List<DataItem>): RecyclerView.Adapter<MyOrderAdapter.MyViewHolder>() {

    private var context: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myorder_row_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

       return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_order_id.text = list.get(position).id.toString()
        holder.tv_order_cost.text=list.get(position).cost.toString()
        holder.tv_order_date.text=list.get(position).created.toString()

    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_order_id: TextView
        internal var tv_order_date: TextView
        internal var tv_order_cost: TextView


        init {
            tv_order_id = itemView.findViewById<View>(R.id.tv_order_id) as TextView
            tv_order_cost= itemView.findViewById<View>(R.id.tv_order_cost) as TextView
            tv_order_date= itemView.findViewById<View>(R.id.tv_order_date) as TextView
        }
    }
}