package com.example.project7.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project7.databinding.ActivityMainBinding
import com.example.project7.view_model.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewModel.apply {
                executeGetPopularMovies(1)

                initializeRecycleView()

                popularMovies.observe(this@MainActivity, {
                    adapter.populateData(it)
                })
            }
        }
    }

    private fun initializeRecycleView() {
        binding.apply {
            adapter = MovieAdapter()
            rvMovies.adapter = adapter
            rvMovies.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

}