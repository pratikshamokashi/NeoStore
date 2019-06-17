package com.example.neostoreapp.Presenter


    import android.text.TextUtils
    import com.example.neostoreapp.View.LoginView
    import com.example.neostoreapp.models.LoginResponse
    import com.example.neostoreapp.services.ApiClient
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response

    class LoginPresenter():LoginInterface {

        lateinit var mView: LoginView

        constructor(loginView: LoginView) : this() {
            this.mView=loginView
        }
        override fun login(email: String, password: String) {
            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
            {
                  mView.loginValidation()
            }
            else {
                val apiClient= ApiClient.instance.apiServices.login(email, password)
                apiClient.enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                        if(response != null)
                        {
                            val res =response.body()

                            if (res != null)
                            {
                                mView.loginSucess()
                                mView.response(res)
                            }
                        }
                        else{
                            mView.loginFailure()
                        }

                    }

                    override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                        mView.loginFailure()
                    }


                })

            }

        }

    }