package com.example.neostoreapp.ui.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neostoreapp.R
import kotlinx.android.synthetic.main.sample_row.view.*

 class SampleAdapter: RecyclerView.Adapter<SampleAdapter.MyViewHolder>() {
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_row, parent, false)
         return MyViewHolder(view)
     }

     override fun getItemCount(): Int {
            return 2
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.setText("Android Recycler Starting")
     }


     inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
internal var tvName:TextView
        init {
            tvName=itemView.findViewById(R.id.tvname)as TextView
        }
    }
}