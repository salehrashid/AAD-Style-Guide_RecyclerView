package com.app.recyclerview.first_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.recyclerview.R
import com.app.recyclerview.databinding.ActivityFirstBinding
import com.app.recyclerview.databinding.AnimalItemBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate untuk mengambil layout
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animalList = AnimalModel(this).getAnimalList()
        binding.recyclerView.adapter = AnimalAdapter(animalList)
    }
}