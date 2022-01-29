package com.shahinbashar.test.data

import com.google.gson.annotations.SerializedName

data class From(

    @SerializedName("address") var address: String? = null,
    @SerializedName("name") var name: String? = null

)