package com.example.neostoreapp.ui.productdetails

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.neostoreapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_fragment.*
import kotlinx.android.synthetic.main.dialog_fragment.txt_productname

class ProductDialogFragment: androidx.fragment.app.DialogFragment() {
    lateinit var product_id: String
    lateinit var mListener:DialogSetQuantityContract
    lateinit var image: String
    lateinit var title: String
    lateinit var quantity:String
    lateinit var access_token:String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, data: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_fragment,container,false)
      // var image:String = data?.get("image") as String
        image = arguments?.getString("img").toString()
        title = arguments?.getString("title").toString()
       quantity = arguments?.getFloat("rating").toString()
       product_id = arguments?.getString("id").toString()
       access_token=arguments?.getString("access_token").toString()
        return view
         }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is DialogSetQuantityContract) {
            mListener = context
        } else {
            throw ClassCastException(
                    context.toString() + " must implement OnDogSelected.")
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val image = arguments?.getString("image")
        val title = arguments?.getString("title")
        txt_productname.setText(title)
        Picasso.with(context).load(image).into(img_product_selected)
        et_enterQuantity.setText(quantity)



        btn_buySetQuantity.setOnClickListener {
            quantity=et_enterQuantity.text.toString()
            if (quantity > "8") {
                Toast.makeText(context,"Quantity must be 1 to 8",Toast.LENGTH_SHORT).show()
            }else
            {
                mListener.setQuantity(access_token, product_id, quantity)
                dialog.dismiss()
            }
        }
    }

    interface DialogSetQuantityContract {
        fun setQuantity(access_token:String,product_id: String, quantity: String)
    }
}