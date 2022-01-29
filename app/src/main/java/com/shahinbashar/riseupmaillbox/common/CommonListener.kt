package com.shahinbashar.riseupmaillbox.common

interface CommonListener {
    fun onSuccess(msg: String)
    fun onFailed(msg:String)
    fun onNavigate()
}