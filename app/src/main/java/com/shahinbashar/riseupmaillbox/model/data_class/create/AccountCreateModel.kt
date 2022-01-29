package com.shahinbashar.riseupmaillbox.model.data_class.create

import com.google.gson.annotations.SerializedName


data class AccountCreateModel(

    @SerializedName("id") var id: String? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("quota") var quota: Int? = null,
    @SerializedName("used") var used: Int? = null,
    @SerializedName("isDisabled") var isDisabled: Boolean? = null,
    @SerializedName("isDeleted") var isDeleted: Boolean? = null,
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("updatedAt") var updatedAt: String? = null

)