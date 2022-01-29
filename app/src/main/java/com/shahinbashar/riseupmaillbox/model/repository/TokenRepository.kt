package com.shahinbashar.riseupmaillbox.model.repository
import com.shahinbashar.test.remote.ApiInterface
import javax.inject.Inject
class TokenRepository @Inject constructor(private val api:ApiInterface) {
    fun getToken()=api.getToken("shahin@sinaite.net","123456")
}