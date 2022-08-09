package com.app.recyclerview.api_recyclerview2.network

import com.app.recyclerview.api_recyclerview2.data.UserResponse
import com.app.recyclerview.api_recyclerview2.data.UserResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getListUser(): Call<ArrayList<UserResponseItem>>
}