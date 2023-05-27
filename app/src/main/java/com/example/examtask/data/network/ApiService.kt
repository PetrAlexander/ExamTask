package com.example.examtask.data.network

import com.example.examtask.data.models.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("movies")
    suspend fun getMovies(): Response<List<Movie>>

    @GET("movies/{movieTitle}")
    suspend fun addMovie(@Path("movieTitle") movieTitle: String): Response<Movie>
}