package com.shahinbashar.riseupmaillbox.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.shahinbashar.riseupmaillbox.common.ActivitySwape
import com.shahinbashar.riseupmaillbox.common.CommonListener
import com.shahinbashar.riseupmaillbox.utils.shared_preference.SharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(@ApplicationContext context: Context) : ViewModel(){
    var commonListener:CommonListener?=null
    var activitySwape:ActivitySwape?=null
    var sharedPref=SharedPref(context)
    fun checkLoginStatus() {
        if(sharedPref.getData().login){
            ////every time JWToken has been changed.
            ///for that message could not be read.
        }
    }
}

