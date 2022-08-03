package com.app.recyclerview.api_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.recyclerview.databinding.ActivityThirdBinding
import com.app.recyclerview.api_recyclerview.data.RClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    private var listRecipe = MutableLiveData<RecipeResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getRecipe()
        listRecipe.observe(this) {
            setUpRecyclerView(it)
        }
    }

    private fun setUpRecyclerView(it: RecipeResponse?) {
        binding.rvListRecipe.apply {
            val mAdapter = RecipeAdapter()
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mAdapter
            mAdapter.setData(it?.data as List<DataItem>)
        }
    }

    private fun getRecipe() {
        RClient.rService.getRecipe().enqueue(
            object : Callback<RecipeResponse> {
                override fun onResponse(
                    call: Call<RecipeResponse>,
                    response: Response<RecipeResponse>
                ) {
                    if (response.isSuccessful) {
                        listRecipe.value = response.body()
                        binding.progressCircular.visibility = View.INVISIBLE
                    }
                }

                override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {

                }
            }
        )
    }
}