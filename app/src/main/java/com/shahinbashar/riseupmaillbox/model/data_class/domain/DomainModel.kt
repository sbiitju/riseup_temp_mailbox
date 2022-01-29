package com.shahinbashar.test.data.domain

import com.google.gson.annotations.SerializedName

data class DomainModel(
    @SerializedName("@context") var context: String? = null,
    @SerializedName("@id") var id: String? = null,
    @SerializedName("@type") var type: String? = null,
    @SerializedName("hydra:member") var hydramember: ArrayList<HydraMember> = arrayListOf(),
    @SerializedName("hydra:totalItems") var hydratotalItems: Int? = null
)