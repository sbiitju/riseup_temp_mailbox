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
    private val _response=MutableLiveData<TokenModel>()
    val responseToken:LiveData<TokenModel> get() = _response
    init {
        getTokenValue()
    }

    private fun getTokenValue(){
        val call: Call<TokenModel> = repository.getToken()
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
                }

            }

            // this method will be triggered if network call failed
            override fun onFailure(call: Call<TokenModel>, t: Throwable) {
            }
        })


    }
}