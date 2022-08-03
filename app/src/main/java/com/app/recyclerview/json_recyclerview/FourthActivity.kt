package com.app.recyclerview.json_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.recyclerview.databinding.ActivityFourthBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.StandardCharsets

class FourthActivity : AppCompatActivity() {

    private val modelPahlawan: MutableList<ModelPahlawan> = ArrayList()
    lateinit var pahlawanAdapter: PahlawanAdapter
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListPahlawan.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FourthActivity)
        }
        getListPahlawan()
    }

    private fun getListPahlawan() {
        try {
            //membuka asset json
            val stream = assets.open("pahlawan_nasional.json")
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            val strContent = String(buffer, StandardCharsets.UTF_8)
            try {
                val jsonObject = JSONObject(strContent)
                val jsonArray = jsonObject.getJSONArray("daftar_pahlawan")

                //intinya for (looping) untuk mengambil data yang berada dalam json
                for (i in 0 until jsonArray.length()) {
                    val jsonObjectData = jsonArray.getJSONObject(i)
                    val dataApi = ModelPahlawan()
                    dataApi.nama = jsonObjectData.getString("nama")
                    dataApi.namaLengkap = jsonObjectData.getString("nama2")
                    dataApi.image = jsonObjectData.getString("img")
                    modelPahlawan.add(dataApi)
                }
                pahlawanAdapter = PahlawanAdapter(modelPahlawan)
                binding.rvListPahlawan.adapter = pahlawanAdapter
            } catch (e: JSONException){
                e.printStackTrace()
            }
        } catch (e: IOException) {
            Toast.makeText(this,"Did not get data", Toast.LENGTH_SHORT).show()
        }
    }
}