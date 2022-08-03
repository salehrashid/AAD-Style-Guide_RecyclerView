package com.app.recyclerview.object_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.recyclerview.databinding.ActivitySecondBinding
import com.app.recyclerview.object_recyclerview.data.VehicleModel

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vehicleList = VehicleModel.listData
        binding.recyclerViewVehicle.adapter = VehicleAdapter(vehicleList)
        binding.recyclerViewVehicle.layoutManager = LinearLayoutManager(this)
    }
}