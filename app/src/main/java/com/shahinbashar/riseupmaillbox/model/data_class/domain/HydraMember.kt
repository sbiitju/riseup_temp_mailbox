package com.shahinbashar.test.data.domain

import com.google.gson.annotations.SerializedName

data class HydraMember(
    @SerializedName("@id") var id: String? = null,
    @SerializedName("@type") var type: String? = null,
    @SerializedName("id") var userid: String? = null,
    @SerializedName("domain") var domain: String? = null,
    @SerializedName("isActive") var isActive: Boolean? = null,
    @SerializedName("isPrivate") var isPrivate: Boolean? = null,
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("updatedAt") var updatedAt: String? = null
)