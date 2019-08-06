package com.example.neostoreapp.ui.base

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import android.view.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.toolbar.*
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.accountdetails.MyAccountActivity
import com.example.neostoreapp.ui.address.AddressDataActivity
import com.example.neostoreapp.ui.login.LoginActivity
import com.example.neostoreapp.ui.mycartlisting.MyCartActivity
import com.example.neostoreapp.ui.myorder.MyOderListActivity
import com.example.neostoreapp.ui.productlisting.ProductActivity


abstract class BaseActivity : AppCompatActivity(),BaseView, NavigationView.OnNavigationItemSelectedListener {

    abstract val layout:Int
   // private lateinit var  getPresenter:BasePresenter
    abstract fun init()

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_base)

        //inflated view pass from child activity
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(layout, null);
        container.addView(view)

        if(navigationView!=null){
            navigationView.setNavigationItemSelectedListener(this)
        }

       init()

        menu_img.setOnClickListener{
            drawer_layout.openDrawer(Gravity.LEFT)

        }

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        when(id){

              R.id.mycart ->{
                  val intent=Intent(this,MyCartActivity::class.java)
                  startActivity(intent)
              }
            R.id.myorder ->{
                val intent=Intent(this,MyOderListActivity::class.java)
                startActivity(intent)
            }
            R.id.table->{
                val intent=Intent(this, ProductActivity::class.java)
                startActivity(intent)
            }
            R.id.myaccount->{
                val intent=Intent(this, MyAccountActivity::class.java)
                startActivity(intent)
            }
            R.id.logout->{
                sharedPreferences = getSharedPreferences("myPref", 0)
                editor= sharedPreferences.edit()
                editor.clear()
                editor.apply()
                editor.putBoolean("isLogin",false)
                val intent=Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return true
    }

    override fun onStart() {
        super.onStart()
        //getPresenter.start()
    }

    override fun onStop() {
        super.onStop()
        //getPresenter.stop()
    }
    fun showToast(message: String?){
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }
      override fun showError()
    {
        Toast.makeText(this,"This is warning for user",Toast.LENGTH_SHORT).show()
    }
    override fun showLoading()
    {

    }
    override fun hideLoading()
    {

    }
    override fun logout()
    {

    }
}