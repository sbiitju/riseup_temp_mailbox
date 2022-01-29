package com.shahinbashar.riseupmaillbox.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahinbashar.riseupmaillbox.model.data_class.create.AccountCreateModel
import com.shahinbashar.riseupmaillbox.model.repository.AccountRepository
import com.shahinbashar.test.data.domain.DomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(private val repository: AccountRepository):ViewModel(){
    private val _response=MutableLiveData<AccountCreateModel>()
    val accountStatus get() = _response
    init {
        makeAccount()
    }

    private fun makeAccount() {
        val call: Call<AccountCreateModel> = repository.createAccount()
        call.enqueue(object : Callback<AccountCreateModel> {

            // if retrofit network call success, this method will be triggered
            override fun onResponse(
                call: Call<AccountCreateModel>,
                response: Response<AccountCreateModel>
            ) {
                if (response.body()!=null){
                    _response.postValue(response.body())
                    Log.d("Shahin Bashar",response.body().toString())
                }else{
                    Log.d("Shahin Bashar","Error hoyse")
                }

            }

            // this method will be triggered if network call failed
            override fun onFailure(call: Call<AccountCreateModel>, t: Throwable) {
            }
        })
    }
}