package com.shahinbashar.test.remote

import com.shahinbashar.riseupmaillbox.model.Params
import com.shahinbashar.riseupmaillbox.model.data_class.create.AccountCreateModel
import com.shahinbashar.riseupmaillbox.model.data_class.token.TokenModel
import com.shahinbashar.test.data.MessegeModel
import com.shahinbashar.test.data.domain.DomainModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("domains")
    fun getDomain(): Call<DomainModel>

    @POST("token")
    fun getToken(
        @Body params:Params
    ): Call<TokenModel>

    @GET("messages?page=1")
    fun getInBoxInfo(): Call<MessegeModel>

    @POST("accounts")
    fun makeAccount(
       @Body params:Params
    ): Call<AccountCreateModel>
}