package com.shahinbashar.riseupmaillbox.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahinbashar.riseupmaillbox.model.data_class.token.TokenModel
import com.shahinbashar.riseupmaillbox.model.repository.TokenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class TokenViewModel @Inject constructor(private val repository: TokenRepository) : ViewModel() {
    val email=MutableLiveData<String>()
    val password=MutableLiveData<String>()
    private val _response=MutableLiveData<TokenModel>()
    val responseToken:LiveData<TokenModel> get() = _response
    init {
        email.postValue("shahin@sinaite.net")
        password.postValue("123456")
        getTokenValue()
    }

    private fun getTokenValue(){
        val call: Call<TokenModel> = repository.getToken(email.value.toString(),password.value.toString())
        call.enqueue(object : Callback<TokenModel> {

            // if retrofit network call success, this method will be triggered
            override fun onResponse(
                call: Call<TokenModel>,
                response: Response<TokenModel>
            ) {
                if (response.body()!=null){
                    _response.postValue(response.body())
                }else{
                    Log.d("Shahin Bashar","Error hoyse")
                    Log.d(email.value.toString(),password.value.toString())
                }

            }

            // this method will be triggered if network call failed
            override fun onFailure(call: Call<TokenModel>, t: Throwable) {
            }
        })


    }
}