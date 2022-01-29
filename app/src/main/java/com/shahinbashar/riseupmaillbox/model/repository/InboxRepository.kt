package com.shahinbashar.riseupmaillbox.model.repository

import com.shahinbashar.test.remote.ApiInterface
import javax.inject.Inject

class InboxRepository @Inject constructor(private val api: ApiInterface) {
    fun ggetInboxData()=api.getInBoxInfo()
}