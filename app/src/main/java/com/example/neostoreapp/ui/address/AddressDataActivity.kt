package com.example.neostoreapp.ui.address

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.toolbar.*

class AddressDataActivity : BaseActivity() {
    override val layout=R.layout.activity_address


    override fun init() {
        txt_neostore1.setText("Add Address")
        menu_img.visibility= View.GONE
      //  search_img.visibility= View.GONE
        val db= Room.databaseBuilder(applicationContext, AddressDB::class.java,"address.db")
                .build()
        ab_back_white.setOnClickListener {
            finish()
        }
        btn_save_address.setOnClickListener {
            Thread {
                val address = AddressEntity()
                address.address = et_address.text.toString()
                address.city1 = et_city1.text.toString()
                address.city2 =et_city2.text.toString()
                address.state=et_state.text.toString()
                address.zipcode=et_zipcode.text.toString()
                address.country=et_country.text.toString()
                db.empDao().saveData(address)
                val intent= Intent(this,AddressListingActivity::class.java)
                startActivity(intent)

                db.empDao().reademp().forEach {
                    Log.d("tag", "employe data" + it.address)
                    Log.d("tag", "employe data2" + it.city1)
                }
            }.start()
        }
    }

}


