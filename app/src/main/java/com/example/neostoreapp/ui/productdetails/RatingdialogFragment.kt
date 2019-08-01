package com.example.neostoreapp.ui.productdetails

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neostoreapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_fragment.txt_productname
import kotlinx.android.synthetic.main.rating_dialog_fragment.*
import kotlinx.android.synthetic.main.row_layout.*

class RatingdialogFragment : androidx.fragment.app.DialogFragment() {
    lateinit var product_id: String
    lateinit var mListener: DialogRatingContract
    lateinit var image: String
    lateinit var title: String
    lateinit var rating: String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, data: Bundle?): View? {
        val view = inflater.inflate(R.layout.rating_dialog_fragment, container, false)
        image = arguments?.getString("img").toString()
        title = arguments?.getString("title").toString()
        rating = arguments?.getFloat("rating").toString()
        product_id = arguments?.getString("id").toString()
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is DialogRatingContract) {
            mListener = context
        } else {
            throw ClassCastException(
                    context.toString() + " must implement OnDogSelected.")
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d("TAG", "Title: " + title)
        Log.d("tag", "image::" + image+ " prod_id:"+product_id)
        txt_productname.setText(title)
        Picasso.with(context).load(image).into(img_product_rating)
        rating_dialog.rating = rating.toFloat()
        // rating_dialog.rating = rating!!

        btn_set_rate.setOnClickListener(View.OnClickListener {
            val mRating = rating_dialog.rating
            mListener.applyRating(product_id, mRating.toString())
            dialog.dismiss()
        })

    }

    interface DialogRatingContract {
        fun applyRating(product_id: String, rating: String)
    }
}