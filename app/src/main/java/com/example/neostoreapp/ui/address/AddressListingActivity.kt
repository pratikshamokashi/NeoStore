package com.example.neostoreapp.ui.address

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.mycartlisting.MyCartActivity
import com.example.neostoreapp.ui.resetpassword.Reset1Response
import com.example.neostoreapp.ui.resetpassword.ResetViewModel
import kotlinx.android.synthetic.main.activity_address_listing.*
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_my_cart.*
import kotlinx.android.synthetic.main.address_row_layout.*
import kotlinx.android.synthetic.main.toolbar.*

class AddressListingActivity :BaseActivity() {
    override val layout = R.layout.activity_address_listing
    lateinit var myadapter: AddressListAdapter
    private lateinit var sharedPreferences: SharedPreferences
    lateinit  var viewModel: AddressViewModel

    override fun init() {
        Log.d("tag", "INTHREAD")
        txt_neostore1.setText("Address List")
        menu_img.visibility= View.GONE
        //  search_img.visibility= View.GONE
        val db= Room.databaseBuilder(applicationContext, AddressDB::class.java,"address.db")
                .build()
        myadapter = AddressListAdapter(mutableListOf(),this@AddressListingActivity)
        address_recycler_view.adapter=myadapter
        Thread{
            Log.d("tag", "in thread")
            val mAddress=db.empDao().reademp()
                myadapter.addAdress(mAddress)
                myadapter.notifyDataSetChanged()

        }.start()

        ab_back_white.setOnClickListener {
            finish()
        }
        btn_place_order.setOnClickListener{

            var address =address_layout.toString()
            sharedPreferences = getSharedPreferences("myPref", 0)
            viewModel.orderPlaced(sharedPreferences.getString("access_token",null),address)
        }
        viewModel= ViewModelProviders.of(this).get(AddressViewModel::class.java)
        viewModel.orderPlaced().observe(this, Observer<OrderResponse>{
            if(it!=null)
                orderSucess(it)
            else{

            }
        })
    }
    private fun orderSucess(res:OrderResponse)
    {
      showToast(res.userMsg)

        val intent = Intent(this, MyCartActivity::class.java)
        startActivity(intent)
        finish()

    }

}
