package com.example.neostoreapp.ui.productdetails

import android.content.ClipData
import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.neostoreapp.R

import com.squareup.picasso.Picasso

class ProductAdapter(private var data: List<ProductImagesItemModel>?, context:Context, var listner:onItemClick): androidx.recyclerview.widget.RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    private var context: Context? = context

   // var listener:onItemClick? = null
    fun setToAdapter(data: List<ProductImagesItemModel>)
    {
        this.data=data
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view=LayoutInflater.from(p0.context).inflate(R.layout.image_layout,p0,false)
        return MyViewHolder(view)
    }


    override fun getItemCount(): Int {
        if (data == null) {
            return 0
        } else {
           return data!!.size
        }
    }
    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        Picasso.with(context).load(data?.get(p1)?.image).into(p0.img_productlist)

        p0.img_productlist.setOnClickListener(){
            Log.d("tag","onclick")
            listner.onClicked(p1)
            //  Picasso.with(context).load(data?.get(p1)?.image).into(p0.img_productlist)
        }

    }

       inner class MyViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
       // internal var table_img: ImageView
           internal var img_productlist:ImageView

        init {
            img_productlist=itemView.findViewById<View>(R.id.img_productlist)as ImageView
        }
    }
    interface onItemClick{

        fun onClicked(position: Int)

    }
}
