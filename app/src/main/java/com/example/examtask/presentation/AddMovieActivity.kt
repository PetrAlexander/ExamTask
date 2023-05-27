package com.example.examtask.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.examtask.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddMovieActivity : AppCompatActivity() {

    lateinit var etInputMovie: EditText
    lateinit var btnAddMovie: FloatingActionButton
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initViews()
        btnAddMovie.setOnClickListener {
            val movieTitle = etInputMovie.text.toString()
            viewModel.addMovie(movieTitle)
            finish()
        }
    }

    private fun initViews() {
        etInputMovie = findViewById(R.id.etInputMovie)
        btnAddMovie = findViewById(R.id.btnAddMovie)
    }

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, AddMovieActivity::class.java)
        }
    }
}