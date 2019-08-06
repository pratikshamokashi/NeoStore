package com.example.neostoreapp.ui.mycartlisting

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.neostoreapp.R
import com.squareup.picasso.Picasso

class MyCartAdapter(private var data: List<DataItem>?, context: Context):RecyclerView.Adapter<MyCartAdapter.MyViewHolder>() {

    private var context: Context = context


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.mycart_row_layout, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (data == null) {
            return 0
        } else {
            return data!!.size
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_table1.text= data!!.get(position).product?.name
        holder.tv_table2.text= data!!.get(position).product?.productCategory
        holder.tv_table3.setText("Rs:"+data!!.get(position).product?.cost.toString())
        Picasso.with(context).load(data!!.get(position).product?.productImages).into(holder.table_img)

    }
       inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_table1: TextView
        internal var tv_table2: TextView
        internal var table_img: ImageView
        internal var tv_table3: TextView


        init {
            tv_table1 = itemView.findViewById<View>(R.id.mycart_tv_tbl1) as TextView
            tv_table2 = itemView.findViewById<View>(R.id.mycart_tv_tbl2) as TextView
            table_img = itemView.findViewById<View>(R.id.mycart_tbl1_img) as ImageView
            tv_table3 = itemView.findViewById<View>(R.id.mycart_rs) as TextView
        }
    }
}

