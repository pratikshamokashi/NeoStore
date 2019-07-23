package com.example.neostoreapp.ui.productdetails

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.neostoreapp.R

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductAdapter(private var data: List<ProductImagesItem>?, context:Context, var listner:onItemClick): RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    private var context: Context? = context

   // var listener:onItemClick? = null
    fun setToAdapter(data: List<ProductImagesItem>)
    {
        this.data=data
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view=LayoutInflater.from(p0.context).inflate(R.layout.image_layout,p0,false)
        return MyViewHolder(view)
    }


    override fun getItemCount(): Int {
        Log.d("tag","count1()"+data)
        if (data == null) {
            return 0
        } else {
            Log.d("tag","count2()"+data)
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

       inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // internal var table_img: ImageView
           internal var img_productlist:ImageView

        init {
          //  table_img = itemView.findViewById<View>(R.id.img_productlist) as ImageView
            img_productlist=itemView.findViewById<View>(R.id.img_productlist)as ImageView

        }
    }
    interface onItemClick{

        fun onClicked(position: Int)

    }
}
