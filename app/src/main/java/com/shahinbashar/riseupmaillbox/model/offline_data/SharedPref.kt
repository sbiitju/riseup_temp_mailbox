package com.shahinbashar.riseupmaillbox.model.offline_data

import android.content.Context
import android.content.SharedPreferences
import com.shahinbashar.riseupmaillbox.utils.Const
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPref @Inject constructor(@ApplicationContext context: Context):SharedPrefInterface{

    private var sharedpreferences: SharedPreferences =
        context.getSharedPreferences(Const.User_Info, Context.MODE_PRIVATE)
    var editor=sharedpreferences.edit()
    fun saveToken(token: String){
        editor.putString("Token",token)
    }

    override fun getData(key: String): String {
        return sharedpreferences.getString(key, "")?:""
    }
}