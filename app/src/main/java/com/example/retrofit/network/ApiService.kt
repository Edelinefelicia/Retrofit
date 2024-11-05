package com.example.retrofit.network


import com.example.retrofit.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users?page=2")
    fun getAllUsers(): Call<Users>
}