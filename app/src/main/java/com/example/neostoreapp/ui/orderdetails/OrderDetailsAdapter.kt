package com.example.neostoreapp.ui.orderdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neostoreapp.R
import com.squareup.picasso.Picasso

class OrderDetailsAdapter(context: Context,private var data:List<OrderDetailsItem?>?): RecyclerView.Adapter<OrderDetailsAdapter.MyViewHolder>() {

    private var context: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myorderdetail_row_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
    return data?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_table1.text=data?.get(position)?.prodName
        holder.tv_table2.setText(data?.get(position)?.prodCatName)
        holder.tv_table3.setText("    Rs:"+data?.get (position)?.total.toString())
        Picasso.with(context).load(data?.get(position)?.prodImage).into(holder.table_img)
        holder.tv_qty.setText(" QTY: "+data?.get(position)?.quantity.toString())
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_table1: TextView
        internal var tv_table2: TextView
        internal var table_img: ImageView
        internal var tv_table3: TextView
        internal var tv_qty:TextView


        init {
            tv_table1 = itemView.findViewById<View>(R.id.myorder_tv_tbl1) as TextView
            tv_table2 = itemView.findViewById<View>(R.id.myorder_tv_tbl2) as TextView
            table_img = itemView.findViewById<View>(R.id.myorder_tbl1_img) as ImageView
            tv_table3 = itemView.findViewById<View>(R.id.myorder_rs) as TextView
            tv_qty=itemView.findViewById<View>(R.id.myorder_qty) as TextView
        }
    }
}