package com.app.recyclerview.second_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.recyclerview.databinding.VehicleItemBinding
import com.app.recyclerview.second_recyclerview.data.Vehicle

class VehicleAdapter(private val vehicleList: List<Vehicle>) :
    RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {
    inner class VehicleViewHolder(private val itemBinding: VehicleItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Vehicle) {
            itemBinding.nameItem.text = item.name
            itemBinding.vehicle.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val itemBinding =
            VehicleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VehicleViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val item = vehicleList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return vehicleList.size
    }
}