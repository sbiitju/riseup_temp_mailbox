package com.shahinbashar.riseupmaillbox.model.repository

import com.shahinbashar.riseupmaillbox.model.Params
import com.shahinbashar.riseupmaillbox.model.data_class.token.TokenModel
import com.shahinbashar.test.remote.ApiInterface
import retrofit2.Call
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: ApiInterface) {
    fun getToken(params: Params)=api.getToken(params)
}