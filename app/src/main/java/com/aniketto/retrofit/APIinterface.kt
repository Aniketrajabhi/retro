package com.aniketto.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface APIinterface {

    @GET("posts")
    fun getData(): Call<List<myDataItem>>
}