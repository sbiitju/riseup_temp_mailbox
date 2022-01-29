package com.shahinbashar.riseupmaillbox.viewmodel

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahinbashar.riseupmaillbox.common.CommonListener
import com.shahinbashar.riseupmaillbox.model.Params
import com.shahinbashar.riseupmaillbox.model.data_class.create.AccountCreateModel
import com.shahinbashar.riseupmaillbox.model.repository.AccountRepository
import com.shahinbashar.riseupmaillbox.view.ui.RegistrationFragmentDirections
import com.shahinbashar.test.data.domain.DomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.coroutineContext
import kotlin.math.log

@HiltViewModel
class AccountViewModel @Inject constructor(private val repository: AccountRepository):ViewModel(){
    private val _response=MutableLiveData<AccountCreateModel>()
    var email=MutableLiveData<String>()
    var password=MutableLiveData<String>()
    var commonListener:CommonListener?=null
    val accountStatus get() = _response
    fun onEmailChange(char: CharSequence,start:Int,end:Int,count:Int){
        email.postValue(char.toString())
    }
    fun onPasswordChange(char: CharSequence,start:Int,end:Int,count:Int){
        password.postValue(char.toString())
    }

    fun onRegisstration(view: View){
            if (email.value.isNullOrEmpty()||password.value.isNullOrEmpty()){
                commonListener?.onFailed("Failed")
                return
            }else{
                var params=Params(email.value.toString(), password.value.toString())
                makeAccount(params)
            }
    }
    fun onLogin(view: View){
       commonListener?.onNavigate()
    }


    private fun makeAccount(params: Params) {
        val call: Call<AccountCreateModel> = repository.createAccount(params)
        call.enqueue(object : Callback<AccountCreateModel> {

            // if retrofit network call success, this method will be triggered
            override fun onResponse(
                call: Call<AccountCreateModel>,
                response: Response<AccountCreateModel>
            ) {
                if (response.body()!=null){
                    _response.postValue(response.body())
                    commonListener?.onSuccess("Your account is successfully Created")
                }else{
                    commonListener?.onFailed("Something Is wrong")
                }

            }

            // this method will be triggered if network call failed
            override fun onFailure(call: Call<AccountCreateModel>, t: Throwable) {
            }
        })
    }


}