package com.sumit.kotlinscopefunctionwithapicall

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object{
        private val httpLoggingInterceptor=
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        fun getretrofitinstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl( "https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build()
        }
    }
}


//ANY CLASS OF CLASS IN OBJECT