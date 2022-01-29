package com.shahinbashar.riseupmaillbox.model.data_class.token

import com.google.gson.annotations.SerializedName

data class TokenModel(
    @SerializedName("token" ) var token : String? = null,
    @SerializedName("id"    ) var id    : String? = null
)