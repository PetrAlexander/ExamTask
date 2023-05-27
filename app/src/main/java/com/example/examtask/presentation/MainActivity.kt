package com.example.examtask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.examtask.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var rvMovies: RecyclerView
    lateinit var moviesAdapter: MovieAdapter
    lateinit var viewModel: MainViewModel
    lateinit var btnAddMovie: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        moviesAdapter = MovieAdapter()
        rvMovies.adapter = moviesAdapter
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getMovies()
        viewModel.movies.observe(this) {
            moviesAdapter.movies = it
            Log.d("Movie", it.toString())
        }
        btnAddMovie.setOnClickListener {
            val intent = AddMovieActivity.newInstance(this)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getMovies()
    }

//    override fun onStop() {
//        super.onStop()
//        viewModel.getMovies()
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        viewModel.getMovies()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        viewModel.getMovies()
//    }
    private fun initViews() {
        rvMovies = findViewById(R.id.rv_movies)
        btnAddMovie = findViewById(R.id.btnAddMovie)
    }
}