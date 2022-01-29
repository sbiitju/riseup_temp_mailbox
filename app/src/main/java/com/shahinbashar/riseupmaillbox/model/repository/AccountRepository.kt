package com.shahinbashar.riseupmaillbox.model.repository

import com.shahinbashar.riseupmaillbox.model.Params
import com.shahinbashar.riseupmaillbox.model.data_class.create.AccountCreateModel
import com.shahinbashar.test.remote.ApiInterface
import retrofit2.Call
import javax.inject.Inject

class AccountRepository @Inject constructor(private val api: ApiInterface) {

    fun createAccount(params: Params)=api.makeAccount(params)
}