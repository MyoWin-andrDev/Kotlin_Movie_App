package it.ezzie.kotlin_movie_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.ezzie.kotlin_movie_app.data.Result
import it.ezzie.kotlin_movie_app.databinding.PopularMovieAdapterBinding

class PopularAdapter (val context: Context, val movieList: List<Result>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>(){

    class PopularViewHolder (var binding : PopularMovieAdapterBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding = PopularMovieAdapterBinding.inflate(layoutInflater)
        return PopularViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        var movie = movieList.get(position)
        holder.binding.imageView.set
    }
}