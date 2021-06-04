package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class ChildModel (
    @SerializedName("field_id")
    val fieldID: Int? = null,
    val hint: String? = null,
    @SerializedName("field_type")
    val fieldType: String? = null,
    val keyboard: String? = null,
    val required: Boolean? = null,
    @SerializedName("is_active")
    val isActive: Boolean? = null,
    val icon : String? = null
)