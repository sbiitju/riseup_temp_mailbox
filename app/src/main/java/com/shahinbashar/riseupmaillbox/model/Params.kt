package com.shahinbashar.riseupmaillbox.model

import com.google.gson.annotations.SerializedName

data class Params(
    @SerializedName("address") var address: String? = null,
    @SerializedName("password") var password: String? = null
)
