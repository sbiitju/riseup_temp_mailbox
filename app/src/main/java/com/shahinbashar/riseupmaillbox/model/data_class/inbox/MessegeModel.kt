package com.shahinbashar.test.data

import com.google.gson.annotations.SerializedName

data class MessegeModel(

    @SerializedName("@context") var context: String? = null,
    @SerializedName("@id") var id: String? = null,
    @SerializedName("@type") var type: String? = null,
    @SerializedName("hydra:member") var hydramember: ArrayList<Hydramember> = arrayListOf(),
    @SerializedName("hydra:totalItems") var hydratotalItems: Int? = null

)