package com.shahinbashar.riseupmaillbox.model.repository

import com.shahinbashar.test.remote.ApiInterface
import javax.inject.Inject

class DomainRepository @Inject constructor(private val api: ApiInterface) {
    fun getDoamin()=api.getDomain()
}