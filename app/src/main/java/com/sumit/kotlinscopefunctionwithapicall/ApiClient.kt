package com.sumit.kotlinscopefunctionwithapicall

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

   @GET("/api/users/{ID}")

          fun getUserDetails(@Path("ID") id : Int) : Call<ResponseDTO>

}

//users/2