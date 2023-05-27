package com.example.examtask.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examtask.data.models.Movie
import com.example.examtask.data.network.ApiFactory
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    private val movieList = mutableListOf<Movie>()

    fun getMovies() {
        viewModelScope.launch {
            ApiFactory.apiService.getMovies().let {
                if (it.isSuccessful) {
                    _movies.postValue(it.body())
                } else {
                    Log.d("MainViewModel", "Error ${it.errorBody()}")
                }
            }
        }
    }

    fun addMovie(movieTitle: String) {
        viewModelScope.launch {
            ApiFactory.apiService.addMovie(movieTitle).let {
                if (it.isSuccessful) {
                    val movie = it.body()
                    if (movie != null) {
                        movieList.add(movie)
                        Log.d("If", movie.toString())
                    }
                    _movies.postValue(movieList)
                } else {
                    Log.d("MainViewModel", "Error ${it.errorBody()}")
                }
            }
        }
    }
}