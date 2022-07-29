package com.app.recyclerview

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.recyclerview.databinding.ActivityFirstBinding
import com.app.recyclerview.databinding.ActivityMainBinding
import com.app.recyclerview.first_recyclerview.FirstActivity
import com.app.recyclerview.second_recyclerview.SecondActivity
import com.app.recyclerview.third_recyclerview.ThirdActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstRecyclerView.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        binding.secondRecyclerView.setOnClickListener {
            val intent = (Intent(this, SecondActivity::class.java))
            startActivity(intent)
        }

        binding.thirdRecyclerView.setOnClickListener {
            val intent = (Intent(this, ThirdActivity::class.java))
            startActivity(intent)
        }
    }
}