package com.shahinbashar.riseupmaillbox.viewmodel

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahinbashar.riseupmaillbox.model.repository.InboxRepository
import com.shahinbashar.test.data.Hydramember
import com.shahinbashar.test.data.MessegeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class InboxViewModel @Inject constructor(private val repository: InboxRepository) : ViewModel() {
    private var _response = MutableLiveData<MessegeModel>()
    val inboxInfo get() = _response
    var messege:MutableLiveData<String> =MutableLiveData<String>()
    fun onClick(view: View) {
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
                if (response.body() != null) {
                    _response.postValue(response.body())
//                    makeAlertDialog(response.body()!!.hydramember)
                    var temp = response.body()!!.hydramember.forEach {
                        messege.postValue("From: " + it.from!!.address + "\nSender Name: " + it.from!!.name + "\nSubject: " + it.subject + "\n Email: " + it.intro)
                    }
                    Log.d("Result", response.body()!!.hydramember.toString())
                } else {
                    Log.d("Shahin Bashar", "Error hoyse")
                }

            }

            // this method will be triggered if network call failed
            override fun onFailure(call: Call<MessegeModel>, t: Throwable) {
            }
        })
    }

//    private fun makeAlertDialog(hydramember: ArrayList<Hydramember>) {
//        var dialog:AlertDialog.Builder=AlertDialog.Builder(context)
//        dialog.setTitle("Inbox")

//        dialog.show()
//    }
}