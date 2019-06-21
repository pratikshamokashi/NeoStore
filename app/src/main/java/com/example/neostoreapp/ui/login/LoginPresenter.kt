package com.example.neostoreapp.ui.login

    import android.text.TextUtils
    import android.util.Log
    import com.example.neostoreapp.net.APICallback
    import com.example.neostoreapp.net.APIManager


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

            APIManager().login(email, password, object : APICallback<LoginResponse>() {
                override fun onSucess(code: Int?, response: LoginResponse?) {

                    when (code) {

                        200 -> {
                            mView?.loginSucess(response)
                        }
                        401 -> {
                              mView?.loginFailure()
                            Log.d("Tag","401msg")
                        }
                    }

                }
            })
        }
    }

