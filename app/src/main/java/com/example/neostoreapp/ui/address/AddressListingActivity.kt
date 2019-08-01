package com.example.neostoreapp.ui.address

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_address_listing.*
import kotlinx.android.synthetic.main.activity_my_cart.*
import kotlinx.android.synthetic.main.toolbar.*

class AddressListingActivity :BaseActivity() {
    override val layout = R.layout.activity_address_listing
    lateinit var myadapter: AddressListAdapter

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
    }

}
