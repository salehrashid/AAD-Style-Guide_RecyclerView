package com.app.recyclerview.api_recyclerview.data

import com.app.recyclerview.api_recyclerview.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET

interface RService {
    @GET("recipe")
    fun getRecipe(
    ): Call<RecipeResponse>
}