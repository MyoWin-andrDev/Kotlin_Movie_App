package it.ezzie.kotlin_movie_app.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import it.ezzie.kotlin_movie_app.API.TMDBApiService
import it.ezzie.kotlin_movie_app.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        loadPopularMovie();
    }

    private fun loadPopularMovie() {
        //Creating Retrofit Instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(TMDBApiService::class.java)
        //Define Authorization Token
        val authToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyNzcxNDkwMjY5MjJiZmQ0YTY4MmYyZWFiYTNkOGFiZiIsIm5iZiI6MTcyOTM1ODAyMy4zMTkzMjksInN1YiI6IjY3MTNlNzU3OTlmMjJmMzI2YWFkMjJhOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.EcdIVTEeNaUcyOtV_cOpr8oaO5go6K2KklKXdQL_NR0"

        //Making Api Call
    }
}