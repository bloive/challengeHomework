package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class NewsModel (
    val id: Int = 0,
    val titleKA: String? = null,
    @SerializedName("updated_at")
    val cover: String? = null,
    var isLast: Boolean = false
)