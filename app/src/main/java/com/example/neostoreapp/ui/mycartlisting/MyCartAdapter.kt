package com.example.neostoreapp.ui.mycartlisting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.productdetails.ProductAdapter
import com.example.neostoreapp.ui.productdetails.ProductDetailActivity
import com.squareup.picasso.Picasso

class MyCartAdapter( var data: ArrayList<DataItem>?, context: Context):RecyclerView.Adapter<MyCartAdapter.MyViewHolder>() {

    private var context: Context = context
    lateinit var access_token:String
    lateinit var product_id: String

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
       // holder.sp_qty.dropDownWidth= data!!.get(position).quantity!!
        Picasso.with(context).load(data!!.get(position).product?.productImages).into(holder.table_img)


       /* holder.mycart_row_layout.setOnClickListener {

            val bundle= Bundle()
            bundle.putString("id", data!!.get(position).productId.toString())
            val intent= Intent(context, MyCartActivity::class.java)
            intent.putExtras(bundle)
            ContextCompat.startActivity(context, intent, null)
            mListener.deleteItem(access_token, product_id)
        }*/

    }
    fun removeAt(viewHolder: RecyclerView.ViewHolder) {
            data?.removeAt(viewHolder.adapterPosition)
            notifyItemRemoved(viewHolder.adapterPosition)
        data?.size?.let { notifyItemRangeChanged(viewHolder.adapterPosition, it) }
        }

       inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_table1: TextView
        internal var tv_table2: TextView
        internal var table_img: ImageView
        internal var tv_table3: TextView
        internal var sp_qty:Spinner
        internal var mycart_row_layout:RelativeLayout



        init {
            tv_table1 = itemView.findViewById<View>(R.id.mycart_tv_tbl1) as TextView
            tv_table2 = itemView.findViewById<View>(R.id.mycart_tv_tbl2) as TextView
            table_img = itemView.findViewById<View>(R.id.mycart_tbl1_img) as ImageView
            tv_table3 = itemView.findViewById<View>(R.id.mycart_rs) as TextView
            sp_qty = itemView.findViewById<View>(R.id.sp_spinner1) as Spinner
            mycart_row_layout=itemView.findViewById<View>(R.id.mycart_row_layout)as RelativeLayout

            val options = arrayOf("1", "2", "3", "4")
            sp_qty.adapter = ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, options)
            sp_qty.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {
                   // result.text = "Please select option"
                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    //sp_qty.setSelection(position)
                    Log.d("tag","pos: "+p1)
                    sp_qty.setSelection(options.get(position).toInt(),true)
                   //options.get(position)
                }

            }

        }
    }
    interface DeleteContract {
        fun deleteItem(access_token:String,product_id: String)
    }
}

