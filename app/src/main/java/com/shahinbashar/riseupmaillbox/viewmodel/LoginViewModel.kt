package com.shahinbashar.riseupmaillbox.viewmodel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.shahinbashar.riseupmaillbox.common.CommonListener
import com.shahinbashar.riseupmaillbox.model.Params
import com.shahinbashar.riseupmaillbox.model.data_class.token.TokenModel
import com.shahinbashar.riseupmaillbox.model.offline_data.SharedPref
import com.shahinbashar.riseupmaillbox.model.offline_data.SharedPrefInterface
import com.shahinbashar.riseupmaillbox.model.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository,@ApplicationContext context: Context) : ViewModel() {
    private val _response=MutableLiveData<TokenModel>()
    val responseToken:LiveData<TokenModel> get() = _response
    var email=MutableLiveData<String>()
    var password=MutableLiveData<String>()
    var commonListener: CommonListener?=null
    var sharedPrefInterface:SharedPref=SharedPref(context)
    val accountStatus get() = _response
    fun onEmailChange(char: CharSequence,start:Int,end:Int,count:Int){
        email.postValue(char.toString())
    }
    fun onPasswordChange(char: CharSequence,start:Int,end:Int,count:Int){
        password.postValue(char.toString())
    }

    fun getLogin(view: View){
        if (email.value.isNullOrEmpty()||password.value.isNullOrEmpty()){
            commonListener?.onFailed("Failed")
            return
        }else{
            var params=Params(email.value.toString(), password.value.toString())
            makeLogin(params)
        }
    }

    private fun makeLogin(params: Params){
        val call: Call<TokenModel> = repository.getToken(params)
        call.enqueue(object : Callback<TokenModel> {

            // if retrofit network call success, this method will be triggered
            override fun onResponse(
                call: Call<TokenModel>,
                response: Response<TokenModel>
            ) {
                if (response.body()!=null){
                    commonListener?.onSuccess("You have Successfully Loged In")

                    response.body()!!.token?.let { Log.d("Shahin Bashar", it)
                    }
                    commonListener?.onNavigate()
                }else{
                    commonListener?.onFailed("Failed")
                }
                Log.d("Result", Gson().toJson(response.errorBody()))
            }

            // this method will be triggered if network call failed
            override fun onFailure(call: Call<TokenModel>, t: Throwable) {
            }
        })


    }
}