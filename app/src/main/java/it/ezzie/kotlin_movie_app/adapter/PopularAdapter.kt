package it.ezzie.kotlin_movie_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.ezzie.kotlin_movie_app.data.Movie
import it.ezzie.kotlin_movie_app.databinding.PopularMovieAdapterBinding

class PopularAdapter (val context: Context, val movie : Movie) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>(){

    class PopularViewHolder (private var binding : PopularMovieAdapterBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding = PopularMovieAdapterBinding.inflate(layoutInflater)
        return PopularViewHolder(binding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {

    }
}