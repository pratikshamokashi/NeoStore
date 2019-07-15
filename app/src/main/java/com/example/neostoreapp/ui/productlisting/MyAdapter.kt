package com.example.neostoreapp.ui.productlisting

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.neostoreapp.R
import com.squareup.picasso.Picasso

class MyAdapter(private var data1: List<Data1>?, context: Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var context: Context? = context

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.row_layout, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (data1 == null) {
            return 0
        } else {
            return data1!!.size
        }
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.tv_table1.text = data1!!.get(p1).name
        p0.ratingbar.rating = data1!!.get(p1).rating!!.toFloat()
        p0.tv_table2.text = data1!!.get(p1).producer
        p0.tv_cost.text = data1!!.get(p1).cost.toString()

        Picasso.with(context).load(data1!!.get(p1).productImages).into(p0.table_img)
        //p0.tv_login.text = mDataList[p1].login
    }

    fun setToAdapter(data1: List<Data1>?) {
        this.data1 = data1
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_table1: TextView
        internal var tv_table2: TextView
        internal var tv_cost: TextView
        internal var table_img: ImageView

        internal var ratingbar: RatingBar

        init {
            tv_table1 = itemView.findViewById<View>(R.id.tv_tbl1) as TextView
            ratingbar = itemView.findViewById<View>(R.id.rating_bar) as RatingBar
            tv_table2 = itemView.findViewById<View>(R.id.tv_tbl2) as TextView
            tv_cost = itemView.findViewById<View>(R.id.tv_cost) as TextView
            table_img = itemView.findViewById<View>(R.id.tbl1_img) as ImageView


        }
    }

}