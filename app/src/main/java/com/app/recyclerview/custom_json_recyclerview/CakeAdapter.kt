package com.app.recyclerview.custom_json_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.recyclerview.databinding.RowCakeItemBinding

class CakeAdapter(private val listCake: ArrayList<BatterItem>) :
    RecyclerView.Adapter<CakeAdapter.CakeViewHolder>() {
    inner class CakeViewHolder(val itemCake: RowCakeItemBinding) :
        RecyclerView.ViewHolder(itemCake.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CakeViewHolder(
        RowCakeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CakeAdapter.CakeViewHolder, position: Int) {
        holder.itemCake.apply {
            tvIdBatter.text = listCake[position].id
            tvTypeBatter.text = listCake[position].type
        }
    }

    override fun getItemCount() = listCake.size
}