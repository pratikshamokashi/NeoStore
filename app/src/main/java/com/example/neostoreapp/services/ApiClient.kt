package com.example.neostoreapp.services

import com.example.neostoreapp.utilities.Utils.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    init {
        retrofit = retrofitInstance
    }
    companion object {
        private var apiService : ApiClient? = null
         var retrofit: Retrofit? = null
        val instance : ApiClient
            get(){
                if(apiService == null){
                    apiService = ApiClient()
                }
                return apiService as ApiClient
            }
    }
    private val retrofitInstance : Retrofit
        get() {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(clientInstance)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit as Retrofit
        }

    private val clientInstance: OkHttpClient
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            httpClient.connectTimeout(3, TimeUnit.MINUTES)
            httpClient.readTimeout(3, TimeUnit.MINUTES)
            httpClient.writeTimeout(3, TimeUnit.MINUTES)
            return httpClient.build()
        }

    internal val apiServices: ApiInterface
        get() = retrofit!!.create(ApiInterface::class.java)


}
//    fun getApi(): Retrofit {
//        val builder = Retrofit.Builder().baseUrl(URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .clientInstance(getClientInstance())
//        val retrofit = builder.build()
//        return retrofit
//    }

//    fun getClientInstance():OkHttpClient{
//        val logger : HttpLoggingInterceptor = HttpLoggingInterceptor()
//        logger.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        val httpCLient : OkHttpClient.Builder = OkHttpClient.Builder()
//        httpCLient.addInterceptor(logger)
//        httpCLient.connectTimeout(2,TimeUnit.MINUTES)
//        httpCLient.readTimeout(2,TimeUnit.MINUTES)
//        httpCLient.writeTimeout(2, TimeUnit.MINUTES)
//        return httpCLient.build()
//    }

