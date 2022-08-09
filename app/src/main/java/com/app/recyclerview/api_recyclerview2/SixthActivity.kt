package com.app.recyclerview.api_recyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.recyclerview.api_recyclerview2.data.UserResponseItem
import com.app.recyclerview.api_recyclerview2.network.ApiConfig
import com.app.recyclerview.databinding.ActivityMain2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SixthActivity : AppCompatActivity() {

    private var _binding: ActivityMain2Binding? = null
    private val binding get() =  _binding as ActivityMain2Binding
    private val adapterUser = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataApiPractice()
    }

    private fun setData(data: ArrayList<UserResponseItem>) {
        binding.rvUserApi.apply {
            layoutManager = LinearLayoutManager(this@SixthActivity)
            adapter = adapterUser
            adapterUser.setUserPractice(data)
        }
    }

    private fun getDataApiPractice() {
        ApiConfig.getApiService().getListUser().enqueue(object : Callback<ArrayList<UserResponseItem>>{
            override fun onResponse(
                call: Call<ArrayList<UserResponseItem>>,
                response: Response<ArrayList<UserResponseItem>>
            ) {
                response.body()?.let {
                        setData(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<UserResponseItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }
        })
    }
}