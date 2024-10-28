package it.ezzie.kotlin_movie_app.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import it.ezzie.kotlin_movie_app.api.TMDBApiService
import it.ezzie.kotlin_movie_app.adapter.MovieAdapter
import it.ezzie.kotlin_movie_app.data.Movie
import it.ezzie.kotlin_movie_app.data.Result
import it.ezzie.kotlin_movie_app.databinding.ActivityHomePageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomePage : AppCompatActivity() {
    private lateinit var binding : ActivityHomePageBinding
    private lateinit var movieList: List<Result>
    private lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movieList = arrayListOf()
        initUI();
        loadPopularMovie();
        loadUpcomingMovie()
        loadTopRatedMovie()
    }

    private fun initUI(){
        binding.popularRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.upcomingRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.latestRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun loadPopularMovie() {
        //Creating Retrofit Instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(TMDBApiService::class.java)
        //Define Authorization Token
        val authToken = "Enter Authorization Token" // From TMDB

        //Making Api Call
        val call = apiService.getPopularMovie(authToken)
        call.enqueue(object:Callback<Movie>{
            override fun onResponse(p0: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                  val movies = response.body()!!.results
                        movieList = movies
                        movieAdapter = MovieAdapter(this@HomePage, movieList)
                        binding.popularRecyclerView.adapter = movieAdapter
                    }
                } else {
                    Toast.makeText(this@HomePage, "Response Successful", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(p0: Call<Movie>, t: Throwable){
                    Toast.makeText(this@HomePage, "Response Failed ${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
    fun loadUpcomingMovie(){
    //Making Retrofit Instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(TMDBApiService::class.java)
        val authToken = "Enter Authorization Token" // From TMDB
    //Making Api Call
        val call = apiService.getUpcomingMovie(authToken)
        call.enqueue(object : Callback<Movie>{
            override fun onResponse(p0: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful){
                    val movies = response.body()!!.results
                    response.body()!!.results.forEach { _ ->
                        movieList = movies
                        movieAdapter = MovieAdapter(this@HomePage, movieList)
                        binding.upcomingRecyclerView.adapter = movieAdapter
                    }
                }
            }

            override fun onFailure(p0: Call<Movie>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun loadTopRatedMovie(){
        //Making Retrofit Instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(TMDBApiService::class.java)
        //Making Authorization Token
        val authToken = "Enter Authorization Token" // From TMDB
        //Making API Call
        val call = apiService.getTopRatedMovie(authToken)
            call.enqueue(object:Callback<Movie>{
                override fun onResponse(p0: Call<Movie>, response: Response<Movie>) {
                    if (response.isSuccessful) {
                        val movies = response.body()!!.results
                        response.body()!!.results.forEach {
                            movieList = movies
                            movieAdapter = MovieAdapter(this@HomePage, movieList)
                            binding.latestRecyclerView.adapter = movieAdapter
                        }
                    }
                }

                override fun onFailure(p0: Call<Movie>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
}