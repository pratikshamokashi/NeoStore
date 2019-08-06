package com.example.neostoreapp.ui.myorder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.orderdetails.OrderDetailsActivity
import com.example.neostoreapp.ui.productdetails.ProductDetailActivity

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
        holder.tv_order_cost.setText(" Rs: "+list.get(position).cost.toString())
        holder.tv_order_date.text=list.get(position).created.toString()

        holder.myorder_row_layout.setOnClickListener{
            val bundle =Bundle()
            bundle.putString("id",list.get(position).id.toString())
            val intent =Intent(context,OrderDetailsActivity::class.java)
            intent.putExtras(bundle)
            ContextCompat.startActivity(context,intent,null)
        }

    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_order_id: TextView
        internal var tv_order_date: TextView
        internal var tv_order_cost: TextView
        internal var myorder_row_layout:LinearLayout


        init {
            tv_order_id = itemView.findViewById<View>(R.id.tv_order_id) as TextView
            tv_order_cost= itemView.findViewById<View>(R.id.tv_order_cost) as TextView
            tv_order_date= itemView.findViewById<View>(R.id.tv_order_date) as TextView
            myorder_row_layout=itemView.findViewById<View>(R.id.myorder_row_layout) as LinearLayout
        }
    }
}