package com.app.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.recyclerview.databinding.ActivityMainBinding
import com.app.recyclerview.string_recyclerview.FirstActivity
import com.app.recyclerview.json_recyclerview.FourthActivity
import com.app.recyclerview.object_recyclerview.SecondActivity
import com.app.recyclerview.api_recyclerview.ThirdActivity
import com.app.recyclerview.api_recyclerview2.SixthActivity
import com.app.recyclerview.custom_json_recyclerview.FifthActivity

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

        binding.fourthRecyclerView.setOnClickListener {
            val intent = (Intent(this, FourthActivity::class.java))
            startActivity(intent)
        }

        binding.fifthRecyclerView.setOnClickListener {
            val intent = (Intent(this, FifthActivity::class.java))
            startActivity(intent)
        }

        binding.sixthRecyclerView.setOnClickListener {
            val intent = (Intent(this, SixthActivity::class.java))
            startActivity(intent)
        }
    }
}