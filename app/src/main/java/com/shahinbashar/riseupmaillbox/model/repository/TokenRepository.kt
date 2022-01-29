package com.shahinbashar.riseupmaillbox.model.repository
import com.shahinbashar.riseupmaillbox.viewmodel.TokenViewModel
import com.shahinbashar.test.remote.ApiInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
class TokenRepository @Inject constructor(private val api:ApiInterface) {
    fun getToken(email:String,password:String)=api.getToken(email,password)
}