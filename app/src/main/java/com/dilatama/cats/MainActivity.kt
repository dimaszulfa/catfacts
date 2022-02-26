package com.dilatama.cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.dilatama.cats.databinding.ActivityMainBinding
import com.dilatama.cats.presentation.MainViewModel

class MainActivity : AppCompatActivity() {

    private val _mainViewModel: MainViewModel by viewModels()
    val mainViewModel get() = _mainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.catfacts.observe(this) { catfacts ->
            val listFacts = catfacts.map {
                it.fact
            }
            binding.lvReview.adapter = ArrayAdapter(this, R.layout.item_review, listFacts)

        }
    }
}