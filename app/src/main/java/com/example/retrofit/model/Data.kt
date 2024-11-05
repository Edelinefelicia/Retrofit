package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstname: String,
    @SerializedName("last_name")
    val lastname: String,
    @SerializedName("avatar")
    val  avatar: String

)


