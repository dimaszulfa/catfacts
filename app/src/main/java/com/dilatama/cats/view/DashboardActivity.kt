package com.dilatama.cats.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dilatama.cats.R
import com.dilatama.cats.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private var _binding: ActivityDashboardBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvRandom.setOnClickListener {  }


    }
}