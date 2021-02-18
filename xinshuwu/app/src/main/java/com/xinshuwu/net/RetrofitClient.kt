package com.xinshuwu.net

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

open class RetrofitClient {
    private var retrofitClient: RetrofitClient? = null

    private var retrofit: Retrofit? = null

    private var okHttpClient: OkHttpClient? = null

    fun instance(): RetrofitClient? {
        if (retrofitClient == null) {
            synchronized(RetrofitClient::class.java) {
                if (retrofitClient == null) {
                    retrofitClient = RetrofitClient()

                }
            }
        }
        return retrofitClient
    }


    fun okHttpClient(): OkHttpClient? {
        val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.e("logging is ", it)
        })

        val builder = OkHttpClient.Builder()

        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val originalRequest = chain.request()
                val requestBuilder: Request.Builder
                requestBuilder = originalRequest.newBuilder()
//                    .header("token", if (token == null) "" else token)
                val request = requestBuilder.build()
                return chain.proceed(request)
            }
        }


        builder.retryOnConnectionFailure(true)
            .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor)

        okHttpClient = builder.build()
        return okHttpClient
    }

    fun retrofit(apiToUrl: apiToUrl): Retrofit? {
        val url: String = when (apiToUrl) {
            RetrofitClient.apiToUrl.QB -> {
                ApiService.BASE_QUBU_URL
            }
            RetrofitClient.apiToUrl.FZ -> {
                ApiService.BASE_FUZHU_URL
            }
            RetrofitClient.apiToUrl.IQ -> {
                ApiService.BASE_AIQU_URL
            }
        }

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

    enum class apiToUrl {
        QB, FZ, IQ
    }

}