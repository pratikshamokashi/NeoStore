package com.example.neostoreapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.Menu
import android.view.View
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.login.LoginContract
import com.example.neostoreapp.ui.login.LoginPresenter
import com.example.neostoreapp.ui.login.LoginResponse
import com.example.neostoreapp.ui.productlisting.ProductActivity
import com.viewpagerindicator.CirclePageIndicator
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity: BaseActivity(), LoginContract.LoginView  {


    override var layout= R.layout.activity_home
    var  presnter = LoginPresenter(this)
    override val getPresenter: BasePresenter
     get() = presnter

    private var imageModelArrayList:ArrayList<ImageModel>?=null
    private val myimagelist= intArrayOf(R.drawable.slider_img1,R.drawable.slider_img2,R.drawable.slider_img3,R.drawable.slider_img4)

    internal lateinit var viewPager: ViewPager
      //  var search = findViewById(R.id.search_img) as ImageView
    override fun init() {
      ab_back_white.visibility=View.GONE
          imageModelArrayList= ArrayList()
          imageModelArrayList=populateList()
          showPager()

          tableicn.setOnClickListener {
              val bundle=Bundle()
              bundle.putString("product_id","1")
              val intent = Intent(this, ProductActivity::class.java)
              intent.putExtras(bundle)
              startActivity(intent)
             // txt_neostore1.setText("Table")
          }
          sofaicn.setOnClickListener {
              val bundle=Bundle()
              bundle.putString("product_id","3")
              val intent = Intent(this, ProductActivity::class.java)
              intent.putExtras(bundle)
              startActivity(intent)
             // txt_neostore1.setText("Sofas")
          }
          chairicn.setOnClickListener {
              val bundle=Bundle()
              bundle.putString("product_id","2")
              val intent = Intent(this, ProductActivity::class.java)
              intent.putExtras(bundle)
              startActivity(intent)
            //  txt_neostore1.setText("Chairs")
          }
          cupboardicn.setOnClickListener {
              val bundle=Bundle()
              bundle.putString("product_id","4")
              val intent = Intent(this, ProductActivity::class.java)
              intent.putExtras(bundle)
              startActivity(intent)
              //txt_neostore1.setText("Cupboard")
          }

/*
    menu_img.setOnClickListener(){
          Toast.makeText(this,"menu clicked",Toast.LENGTH_SHORT).show()

      }
      search_img.setOnClickListener(View.OnClickListener {
          Toast.makeText(this,"search clicked",Toast.LENGTH_SHORT).show()

      })*/


    }
    private fun populateList():ArrayList<ImageModel> {
        Log.d("Tag","populate method")
        val list=ArrayList<ImageModel>()
        for (i in 0..myimagelist.size-1){
            var imageModel=ImageModel()
            imageModel.setImage_drawable(myimagelist[i])
            list.add(imageModel)
        }
        return list
    }

    private fun showPager()
    {
        var mPager=findViewById(R.id.viewPager) as ViewPager
        mPager.adapter=SlidingImageAdapter(this,this.imageModelArrayList!!)
        val indicator=findViewById(R.id.indicator) as CirclePageIndicator
        indicator.setViewPager(mPager)
       // val density=resources.displayMetrics.density
        indicator.radius
        NUM_PAGES = imageModelArrayList!!.size

        val handler= Handler()
        val update= Runnable {
            if (currentPage==NUM_PAGES){
                currentPage=0
            }
            mPager.setCurrentItem(currentPage++,true)
        }
        val swipeTimer= Timer()
        swipeTimer.schedule(object: TimerTask()
        {
            override fun run() {
                handler.post(update)
            }
        },1000,1000)


        indicator.setOnPageChangeListener(object :ViewPager.OnPageChangeListener
        {
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                currentPage = p0
            }
        })
    }
    companion object {

        private var mPager: ViewPager? = null
        private var currentPage = 0
        private var NUM_PAGES = 0
    }
    override fun loginFailure(errorMsg: String) {

    }

    override fun showEmailError() {

    }

    override fun showPasswordError() {

    }



    override fun loginSucess(res: LoginResponse?) {

    }



    /*override var getPresenter: BasePresenter
        get() = getPresenter
        set(value) {}*/
    /*override var layout = R.layout.activity_home
    override fun init() {
       // setToolbar("home")*/
//}

}