package com.example.neostoreapp.ui.productdetails

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neostoreapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_fragment.*

class RatingdialogFragment:DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, data: Bundle?): View? {
        val view = inflater.inflate(R.layout.rating_dialog_fragment,container,false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val image = arguments?.getString("image")
        val title = arguments?.getString("title")
        Log.d("TAG","Title: "+title)
        Log.d("tag","image::"+img_product)
        txt_productname.setText(title)
        Picasso.with(context).load(image).into(img_product)

    }
}