package com.sumit.kotlinscopefunctionwithapicall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_user_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {

    private  lateinit var  responseDTO: ResponseDTO

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mbtnCallApi.setOnClickListener {
            callApi()
        }

    }

    private fun callApi() {
    val apiClient = Network.getretrofitinstance().create(ApiClient :: class.java)
        apiClient.getUserDetails(2).
        enqueue(object  : Callback<ResponseDTO>{
            override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                response.body()?.run {
                    responseDTO = this

                    responseDTO.data?.apply {
                        tvName.text = responseDTO.data?.first_name
                        tvLastName.text = responseDTO.data?.last_name

                    }

                }
            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {

            }

        })
    }


}