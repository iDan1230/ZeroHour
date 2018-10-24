package com.yzd.sdk.tools

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by yangzhidan on 2018/10/23.
 */
object RetrofitFactory {

    private var retrofit: Retrofit? = null
    val base_url = "https://api.myshitu.com/v2/"
    init {

    }

//
//    fun getInstance(): Retrofit? {
//        if (null == retrofit)
//            retrofit = Retrofit.Builder()
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .client(OkHttpClient.Builder()
//                            .readTimeout((1000 * 10).toLong(), TimeUnit.MILLISECONDS)
//                            .connectTimeout((1000 * 10).toLong(), TimeUnit.MILLISECONDS)
////                            .addInterceptor(HttpHeaderInterceptor())
//                            .build())
//                    //                    .baseUrl(BASE_URL + PORT + VERSION)
//                    .baseUrl(base_url)
//                    .build()
//        return retrofit
//    }

}