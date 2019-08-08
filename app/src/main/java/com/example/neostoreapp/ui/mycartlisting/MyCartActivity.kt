package com.example.neostoreapp.ui.mycartlisting

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import android.graphics.*
import android.graphics.Color.*
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.address.AddressDataActivity
import com.example.neostoreapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_my_cart.*
import kotlinx.android.synthetic.main.mycart_row_layout.*
import kotlinx.android.synthetic.main.toolbar.*

class MyCartActivity : BaseActivity() {


    override val layout=R.layout.activity_my_cart
    private lateinit var sharedPreferences: SharedPreferences

    lateinit  var viewModel: MyCartViewModel
    private var myadapter: MyCartAdapter? = null
    lateinit var list: List<Product>

    override fun init() {
        txt_neostore1.setText("My Cart")
        menu_img.visibility = View.GONE
        search_img.visibility = View.GONE
        Log.d("Tag", "init")

        viewModel = ViewModelProviders.of(this).get(MyCartViewModel::class.java)
        sharedPreferences = getSharedPreferences("myPref", 0)
        viewModel.mycartList(sharedPreferences.getString("access_token", null))

        ab_back_white.setOnClickListener {
         finish()
       }



            viewModel.mycartList().observe(this, Observer<MyCartResponse> {
            if (it != null) {
                   setAdapter(it)
                   mycartSucess(it)


            } else {
                failure()
            }
        })

            btn_order_now.setOnClickListener {
                val intent = Intent(this, AddressDataActivity::class.java)
                startActivity(intent)
                finish()
        }
        initswipe()
    }
        fun setAdapter(res:MyCartResponse)
        {
            myadapter =MyCartAdapter(res.data,this)
            mycart_recycler_view.layoutManager= LinearLayoutManager(this)
            mycart_recycler_view.adapter=myadapter
            myadapter!!.notifyDataSetChanged()
        }

    private fun mycartSucess(response: MyCartResponse){
        tv_total.setText("Rs:"+response.total.toString())

    }
    private fun failure(){

    }
    private fun initswipe(){
        val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val position = viewHolder.adapterPosition
                viewModel.deleteItem(sharedPreferences.getString("access_token", null), myadapter?.data!![viewHolder.adapterPosition]?.productId.toString())

                viewModel.deleteItem().observe(this@MyCartActivity, Observer<DeleteResponse>{
                    if (it != null)
                    {
                        deleteItem(it)
                    }
                })


                myadapter?.removeAt(viewHolder)
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                     dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
                val icon:Bitmap
                val p = Paint()
                if (actionState== ItemTouchHelper.ACTION_STATE_SWIPE)
                {
                    val itemView = viewHolder.itemView
                    val height = itemView.bottom.toFloat() - itemView.top.toFloat()
                    val width = height / 3
                    if (dX < 0) {
                        p.setColor(Color.parseColor("#D32F2F"))
                        val background = RectF(
                                itemView.right.toFloat() + dX / 4,
                                itemView.top.toFloat(),
                                itemView.right.toFloat(),
                                itemView.bottom.toFloat()
                        )
                        c.drawRect(background, p)
                        icon = BitmapFactory.decodeResource(resources,R.drawable.delete)
                        val icon_dest = RectF(
                                itemView.right.toFloat() - 2 * width,
                                itemView.top.toFloat() + width,
                                itemView.right.toFloat() - width,
                                itemView.bottom.toFloat() - width
                        )
                        c.drawBitmap(icon, null, icon_dest,p)
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }


        }
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(mycart_recycler_view)
    }
    private fun deleteItem(response: DeleteResponse){
       showToast(response.userMsg)

    }

}
