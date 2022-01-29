package com.shahinbashar.test.remote

import android.app.Application
import com.google.gson.GsonBuilder
import com.shahinbashar.riseupmaillbox.model.offline_data.SharedPrefInterface
import com.shahinbashar.riseupmaillbox.utils.Const
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

object RetrofitClient {

    private var retrofit: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()

    val client: Retrofit
        get() {
            if (retrofit == null) {
                synchronized(Retrofit::class.java) {
                    if (retrofit == null) {

                        val httpClient = OkHttpClient.Builder()
                                .addInterceptor(TokenInterceptor())
                        val client = httpClient.build()

                        retrofit = Retrofit.Builder()
                                .baseUrl(Const.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create(gson))
                                .client(client)
                                .build()
                    }
                }

            }
            return retrofit!!
        }
}
class TokenInterceptor : Interceptor, Application() {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request = chain.request().newBuilder()
            .header("Authorization", "Bearer ${Const.JWToken}")
            .build()

        return chain.proceed(newRequest)
    }
}