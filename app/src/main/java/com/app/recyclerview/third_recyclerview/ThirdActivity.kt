package com.app.recyclerview.third_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.recyclerview.R
import com.app.recyclerview.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}