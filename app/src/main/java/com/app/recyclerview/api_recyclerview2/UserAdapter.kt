package com.app.recyclerview.api_recyclerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.recyclerview.api_recyclerview2.data.UserResponseItem
import com.app.recyclerview.databinding.RowDataApiItem2Binding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserPracticeViewHolder>() {

    private val listUserPractice = ArrayList<UserResponseItem>()

    inner class UserPracticeViewHolder(val itemUserPractice: RowDataApiItem2Binding) :
        RecyclerView.ViewHolder(itemUserPractice.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserPracticeViewHolder(
        RowDataApiItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserPracticeViewHolder, position: Int) {
        holder.itemUserPractice.apply {
            with(listUserPractice[position]){
                tvName.text = name
                tvEmail.text = email
                tvUsername.text = username
            }
        }
    }

    override fun getItemCount() = listUserPractice.size

    fun setUserPractice(user: ArrayList<UserResponseItem>){
        this.listUserPractice.clear()
        this.listUserPractice.addAll(user)
    }
}