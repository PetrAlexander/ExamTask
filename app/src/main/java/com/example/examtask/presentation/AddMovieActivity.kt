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
    lateinit var addMovieViewModel: AddMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        addMovieViewModel = ViewModelProvider(this)[AddMovieViewModel::class.java]
        initViews()
        btnAddMovie.setOnClickListener {
            val movieTitle = etInputMovie.text.toString()
            addMovieViewModel.addMovie(movieTitle)
        }
        addMovieViewModel.shouldCloseScreen.observe(this) {
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