package com.app.recyclerview.custom_json_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.recyclerview.databinding.ActivityFifthBinding
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class FifthActivity : AppCompatActivity() {

    private val modelCake = ArrayList<BatterItem>()
    lateinit var cakeAdapter: CakeAdapter
    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cakeAdapter = CakeAdapter(modelCake)

        binding.rvCake.adapter = cakeAdapter
        binding.rvCake.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FifthActivity)
        }
        getListCake()
    }

    /** get array JSON **/
    private fun getListCake() {
        val json = getJSONObject()
        try {
            val getRootJson = JSONArray(json)
            for (i in 0 until getRootJson.length()) {
                val jsonObjectData = getRootJson.getJSONObject(i)
                val getBatters = jsonObjectData.getJSONObject("batters")
                val getBatter = getBatters.getJSONArray("batter")

                for (u in 0 until getBatter.length()) {
                    val batterItem = getBatter.getJSONObject(u)
                    val dataJson = BatterItem(
                        id = batterItem.getString("id"),
                        type = batterItem.getString("type")
                    )
                    modelCake.add(dataJson)
                }
            }
            binding.rvCake.adapter = cakeAdapter
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun getJSONObject(): String? {
        val str: String
        try {
            str = assets.open("cake.json").bufferedReader().readText()
        } catch (e: IOException) {
            Log.d("TAG", "getJSONObject: $e")
            return null
        }
        return str
    }
}