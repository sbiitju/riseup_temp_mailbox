package com.shahinbashar.test.data

import com.google.gson.annotations.SerializedName

data class Hydramember(
    @SerializedName("@id"            ) var _id            : String?       = null,
    @SerializedName("@type"          ) var type          : String?       = null,
    @SerializedName("id"             ) var id             : String?       = null,
    @SerializedName("accountId"      ) var accountId      : String?       = null,
    @SerializedName("msgid"          ) var msgid          : String?       = null,
    @SerializedName("from"           ) var from           : From?         = From(),
    @SerializedName("to"             ) var to             : ArrayList<To> = arrayListOf(),
    @SerializedName("subject"        ) var subject        : String?       = null,
    @SerializedName("intro"          ) var intro          : String?       = null,
    @SerializedName("seen"           ) var seen           : Boolean?      = null,
    @SerializedName("isDeleted"      ) var isDeleted      : Boolean?      = null,
    @SerializedName("hasAttachments" ) var hasAttachments : Boolean?      = null,
    @SerializedName("size"           ) var size           : Int?          = null,
    @SerializedName("downloadUrl"    ) var downloadUrl    : String?       = null,
    @SerializedName("createdAt"      ) var createdAt      : String?       = null,
    @SerializedName("updatedAt"      ) var updatedAt      : String?       = null
)