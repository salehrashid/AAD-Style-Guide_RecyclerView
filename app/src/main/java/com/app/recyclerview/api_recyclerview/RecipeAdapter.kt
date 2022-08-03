package com.app.recyclerview.api_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.recyclerview.databinding.RowDataApiItemBinding
import com.bumptech.glide.Glide

class RecipeAdapter() :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    private val recipeList = arrayListOf<DataItem>()

    inner class RecipeViewHolder(val itemRecipe: RowDataApiItemBinding) :
        RecyclerView.ViewHolder(itemRecipe.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemBinding =
            RowDataApiItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemRecipe.apply {
            with(recipeList[position]) {
                tvName.text = title
                Glide.with(imageApi.context).load(images?.get(0)).into(imageApi)
            }
        }
    }

    override fun getItemCount() = recipeList.size

    fun setData(data: List<DataItem>) {
        if (recipeList == null)
            recipeList.clear()
        recipeList.addAll(data)
        notifyDataSetChanged()
    }
}