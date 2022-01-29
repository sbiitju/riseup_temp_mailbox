package com.shahinbashar.riseupmaillbox.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahinbashar.riseupmaillbox.model.data_class.create.AccountCreateModel
import com.shahinbashar.riseupmaillbox.model.repository.InboxRepository
import com.shahinbashar.test.data.MessegeModel
import com.shahinbashar.test.data.domain.DomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class InboxViewModel @Inject constructor(private val repository: InboxRepository):ViewModel() {
    private val _response= MutableLiveData<MessegeModel>()
    val inboxInfo get() = _response
    init {
        getInboxData()
    }

    private fun getInboxData() {
        val call: Call<MessegeModel> = repository.ggetInboxData()
        call.enqueue(object : Callback<MessegeModel> {

            // if retrofit network call success, this method will be triggered
            override fun onResponse(
                call: Call<MessegeModel>,
                response: Response<MessegeModel>
            ) {
                if (response.body()!=null){
                    _response.postValue(response.body())
                    Log.d("Shahin Bashar",response.body().toString())
                }else{
                    Log.d("Shahin Bashar","Error hoyse")
                }

            }

            // this method will be triggered if network call failed
            override fun onFailure(call: Call<MessegeModel>, t: Throwable) {
            }
        })
    }
}