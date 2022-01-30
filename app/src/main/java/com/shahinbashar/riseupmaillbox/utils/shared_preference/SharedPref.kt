package com.shahinbashar.riseupmaillbox.utils.shared_preference

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPref @Inject constructor(@ApplicationContext var context: Context){
    @SuppressLint("CommitPrefEdits")
    fun saveData(sessionModel: SessionModel){
        val sharedPreferences:SharedPreferences=context.getSharedPreferences("OfflineData",Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("JWtoken",sessionModel.JWToken)
        sharedPreferences.edit().putBoolean("login",sessionModel.login)
    }
    fun getData():SessionModel{
        val sharedPreferences:SharedPreferences=context.getSharedPreferences("OfflineData",Context.MODE_PRIVATE)
        var JWtoken=sharedPreferences.getString("JWtoken","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NDM0ODI3MTksInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJ1c2VybmFtZSI6InNoYWhpbkBzaW5haXRlLm5ldCIsImlkIjoiNjFmMjdjZTU1OGQ1NjEzMmM0MDg1NDA1IiwibWVyY3VyZSI6eyJzdWJzY3JpYmUiOlsiL2FjY291bnRzLzYxZjI3Y2U1NThkNTYxMzJjNDA4NTQwNSJdfX0.G8JNZFz2PK74OMIEuSQN25PuhUTRoVmkHSkXnThFoAzsrXb_S186CTMxEoinjuhgtBIK0RsAqJsZTQQTy4ZzkA")
        var login=sharedPreferences.getBoolean("login",false)
        return JWtoken?.let { SessionModel(it,login) }!!
    }
}