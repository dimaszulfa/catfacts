package com.dilatama.cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.dilatama.cats.databinding.ActivityMainBinding
import com.dilatama.cats.presentation.MainViewModel
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {

    private val _mainViewModel: MainViewModel by viewModels()
    val mainViewModel get() = _mainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*        val bottom_nav = binding.chipNavigationBar
        val bottomNavigationView = findViewById<ChipNavigationBar
                >(R.id.chipNavigationBar)
        val navController = findNavController(R.id.blankFragment)
        bottomNavigationView.*/

        mainViewModel.catfacts.observe(this) { catfacts ->
            val listFacts = catfacts.map {
                it.fact
            }
            binding.lvReview.adapter = ArrayAdapter(this, R.layout.item_review, listFacts)


        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return super.onCreateOptionsMenu(menu)


    }
}