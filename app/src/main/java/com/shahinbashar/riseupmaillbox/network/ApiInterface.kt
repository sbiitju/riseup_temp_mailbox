package com.shahinbashar.test.remote

import com.shahinbashar.riseupmaillbox.model.data_class.create.AccountCreateModel
import com.shahinbashar.riseupmaillbox.model.data_class.token.TokenModel
import com.shahinbashar.test.data.MessegeModel
import com.shahinbashar.test.data.domain.DomainModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {
    @GET("domains")
    fun getDomain(): Call<DomainModel>

    @FormUrlEncoded
    @POST("token")
    fun getToken(
        @Field("address") address: String,
        @Field("password") password: String
    ): Call<TokenModel>

    @GET("messages?page=1")
    fun getInBoxInfo(): Call<MessegeModel>

    @FormUrlEncoded
    @POST("accounts")
    fun makeAccount(
        @Field("address") address: String,
        @Field("password") password: String
    ): Call<AccountCreateModel>
}