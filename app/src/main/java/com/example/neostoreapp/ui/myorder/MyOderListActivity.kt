package com.example.neostoreapp.ui.myorder

import android.content.SharedPreferences
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_my_oder_list.*
import kotlinx.android.synthetic.main.toolbar.*

class MyOderListActivity : BaseActivity() {
    override val layout = R.layout.activity_my_oder_list
    private lateinit var sharedPreferences: SharedPreferences

    lateinit  var viewModel: MyOrderViewModel
    private var myadapter: MyOrderAdapter? = null
    lateinit var list:List<DataItem>
    override fun init() {
        txt_neostore1.setText("My Orders")
        menu_img.visibility = View.GONE
        viewModel = ViewModelProviders.of(this).get(MyOrderViewModel::class.java)
        sharedPreferences = getSharedPreferences("myPref", 0)
        viewModel.myorderList(sharedPreferences.getString("access_token", null))

        ab_back_white.setOnClickListener {
            finish()
        }
        viewModel.myorderList().observe(this, Observer<MyOrderResponse> {
            if (it != null) {
                Log.d("tag","sucess102: "+it)
                setAdapter(it)


            } else {
            }
        })
    }

    fun setAdapter(res: MyOrderResponse)
    {
        Log.d("tag","adpter")
        myadapter =MyOrderAdapter(this, res.data as List<DataItem>)
        myorder_recycler_view.layoutManager= androidx.recyclerview.widget.LinearLayoutManager(this)
        myorder_recycler_view.adapter=myadapter
        myadapter!!.notifyDataSetChanged()

    }
}
