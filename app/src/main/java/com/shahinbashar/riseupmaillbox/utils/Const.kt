package com.shahinbashar.riseupmaillbox.utils

import android.content.Context
import android.widget.Toast
import java.util.*

object Const {
    val User_Info: String="user_status"
    var JWToken: String ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NDMzOTkwNzIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJ1c2VybmFtZSI6InNoYWhpbkBzaW5haXRlLm5ldCIsImlkIjoiNjFmMjdjZTU1OGQ1NjEzMmM0MDg1NDA1IiwibWVyY3VyZSI6eyJzdWJzY3JpYmUiOlsiL2FjY291bnRzLzYxZjI3Y2U1NThkNTYxMzJjNDA4NTQwNSJdfX0.OJoT99i4zVlyWk7VAJLRA29dqUOBplMwEWOmNmVNDuHkauFlUA3ftXzpjL9iG-snF2UHvJPRgMS3gUtimt6USg"
    const val BASE_URL="https://api.mail.tm/"

    fun Context.makeToast(string: String){
        Toast.makeText(applicationContext,string,Toast.LENGTH_LONG)
    }
}