package com.example.examtask.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    val description: String,
    @PrimaryKey
    val id: String,
    val poster: String,
    val rating: Double,
    val title: String
)