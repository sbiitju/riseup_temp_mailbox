package com.shahinbashar.riseupmaillbox.model.repository

import com.shahinbashar.test.remote.ApiInterface
import javax.inject.Inject

class AccountRepository @Inject constructor(private val api: ApiInterface) {
    fun createAccount()=api.makeAccount("abcdefhg@sinaite.net","123456")
}