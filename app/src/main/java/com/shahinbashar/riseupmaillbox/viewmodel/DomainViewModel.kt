package com.shahinbashar.riseupmaillbox.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahinbashar.riseupmaillbox.model.data_class.create.AccountCreateModel
import com.shahinbashar.riseupmaillbox.model.data_class.token.TokenModel
import com.shahinbashar.riseupmaillbox.model.repository.AccountRepository
import com.shahinbashar.riseupmaillbox.model.repository.DomainRepository
import com.shahinbashar.test.data.domain.DomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class DomainViewModel @Inject constructor(private val repository: DomainRepository): ViewModel() {
    private val _response= MutableLiveData<DomainModel>()
    val responseDomain: LiveData<DomainModel> get() = _response
    init {
        getDomainResponse()
    }

    private fun getDomainResponse() {
        val call: Call<DomainModel> = repository.getDoamin()
        call.enqueue(object : Callback<DomainModel> {

            // if retrofit network call success, this method will be triggered
            override fun onResponse(
                call: Call<DomainModel>,
                response: Response<DomainModel>
            ) {
                if (response.body()!=null){
                    _response.postValue(response.body())
                    Log.d("Shahin Bashar",response.body().toString())
                }else{
                    Log.d("Shahin Bashar","Error hoyse")
                }

            }

            // this method will be triggered if network call failed
            override fun onFailure(call: Call<DomainModel>, t: Throwable) {
            }
        })
    }
}