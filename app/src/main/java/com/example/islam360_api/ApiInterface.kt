package com.example.islam360_api

import android.telecom.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("NFYsXW")
   suspend fun getData() : Response<Mydata>

}

object DataService{

    val Instance : ApiInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        Instance = retrofit.create(ApiInterface::class.java)
    }
}