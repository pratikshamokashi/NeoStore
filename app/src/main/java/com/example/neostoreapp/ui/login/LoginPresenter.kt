package com.example.neostoreapp.ui.login


    import android.text.TextUtils
    import android.util.Log
    import android.widget.Toast
    import com.example.neostoreapp.net.APICallback
    import com.example.neostoreapp.net.APIManager
    import com.example.neostoreapp.services.ApiClient
    import io.reactivex.Scheduler
    import io.reactivex.android.schedulers.AndroidSchedulers
    import io.reactivex.rxkotlin.subscribeBy
    import io.reactivex.schedulers.Schedulers
    import okhttp3.ResponseBody
    import org.json.JSONObject
    import retrofit2.Response
    import retrofit2.Retrofit
    import android.widget.Toast.makeText as makeText1


class LoginPresenter(loginView: LoginContract.LoginView) : LoginContract.Presenter {
        var mView: LoginContract.LoginView? = null

        override fun loginValidation(email: String, password: String): Boolean {
            when {
                TextUtils.isEmpty(email) -> {

                    mView?.showEmailError()
                    return false
                }
                TextUtils.isEmpty(password) -> {
                    mView?.showPasswordError()
                    return false
                }
                else -> return true
            }
        }

        init {
            this.mView = loginView
        }

        var isRooted: Boolean = true
        override fun start() {
            if (isRooted) mView?.showError()
        }

        override fun stop() {
            mView = null
        }

        override fun login(email: String, password: String) {
            ApiClient().apiServices.login(email, password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onNext = {
                        if (it != null) {

                            mView?.loginSucess(it)
                        }
                    },
                    onError = {
                        mView?.loginFailure(it.localizedMessage)
                    }
                    , onComplete = {
                        //Toast.makeText(this,"sucessfully",Toast.LENGTH_SHORT).show()
                    }
                )

        }



}


    //   ApiClient().retrofitInstance.login(email, password, object : APICallback<LoginResponse>() {
               // override fun onSucess(code: Int?, response: LoginResponse?) {
                 //   mView?.loginSucess(response)
                   /* when (code) {
                        200 -> {

                        }

                    }*/

               // }

           /*     override fun onFail(code: Int?, response: EditProfileResponse<LoginResponse>?, errorBody: ResponseBody?,
                                    retrofit: Retrofit?) {

                    val jObjError = JSONObject(errorBody?.string())
                    mView?.loginFailure("${jObjError.get("message")}")

                Log.d("TAG","data failed:"+"${jObjError.get("message")}")
                }
            })
        }*/