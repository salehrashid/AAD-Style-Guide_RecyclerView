package com.app.recyclerview.object_recyclerview.data

import com.app.recyclerview.R

object VehicleModel {
    private val vehicleName = arrayOf(
        "black hawk 1",
        "black hawk 2",
        "impala 1",
        "impala 2"
    )

    private val vehicleImage = intArrayOf(
        R.drawable.vehicle1,
        R.drawable.vehicle2,
        R.drawable.vehicle3,
        R.drawable.vehicle4
    )

    val listData: ArrayList<Vehicle>
    get() {
        val list = arrayListOf<Vehicle>()
        for (position in vehicleName.indices){
            val vehicle = Vehicle()
            vehicle.name = vehicleName[position]
            vehicle.image = vehicleImage[position]
            list.add(vehicle)
        }
        return list
    }
}