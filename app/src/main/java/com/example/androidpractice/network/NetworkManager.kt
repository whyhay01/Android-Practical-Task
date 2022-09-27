package com.example.androidpractice.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService() = getRetrofit().create(Service::class.java)
}