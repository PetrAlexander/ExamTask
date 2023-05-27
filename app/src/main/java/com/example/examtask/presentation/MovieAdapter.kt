package com.example.examtask.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examtask.R
import com.example.examtask.data.models.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var movies: List<Movie> = listOf()
        set(value) {
            field = value
            Log.d("Value", value.toString())
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.tvTitle.text = movie.title
        holder.tvRating.text = "${movie.rating}/10"
        if (movie.poster != null) {
            Glide.with(holder.itemView)
                .load(movie.poster)
                .into(holder.imageView)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var tvRating: TextView
        var tvTitle: TextView

        init {
            imageView = itemView.findViewById(R.id.ivMovie)
            tvRating = itemView.findViewById(R.id.tvRating)
            tvTitle = itemView.findViewById(R.id.tvTitle)
        }
    }
}