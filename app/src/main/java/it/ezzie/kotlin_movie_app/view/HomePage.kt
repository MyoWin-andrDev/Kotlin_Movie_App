package it.ezzie.kotlin_movie_app.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import it.ezzie.kotlin_movie_app.api.TMDBApiService
import it.ezzie.kotlin_movie_app.adapter.PopularAdapter
import it.ezzie.kotlin_movie_app.data.Movie
import it.ezzie.kotlin_movie_app.data.Result
import it.ezzie.kotlin_movie_app.databinding.ActivityHomePageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomePage : AppCompatActivity() {
    private lateinit var bindingPopular : ActivityHomePageBinding
    private lateinit var movieList: List<Result>
    private lateinit var popularAdapter: PopularAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindingPopular = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(bindingPopular.root)
        movieList = arrayListOf()
        initUI();
        loadPopularMovie();
    }

    private fun initUI(){
        bindingPopular.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
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
        val call = apiService.getPopularMovie(authToken)
        call.enqueue(object:Callback<Movie>{
            override fun onResponse(p0: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                  val movies = response.body()!!.results
                    response.body()!!.results.forEach {
                        movieList = movies
                        popularAdapter = PopularAdapter(this@HomePage, movieList)
                        bindingPopular.popularRecyclerView.adapter = popularAdapter
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
        val authToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyNzcxNDkwMjY5MjJiZmQ0YTY4MmYyZWFiYTNkOGFiZiIsIm5iZiI6MTcyOTM1ODAyMy4zMTkzMjksInN1YiI6IjY3MTNlNzU3OTlmMjJmMzI2YWFkMjJhOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.EcdIVTEeNaUcyOtV_cOpr8oaO5go6K2KklKXdQL_NR0"
    //Making Api Call
        val call = apiService.getUpcomingMovie(authToken)
        call.enqueue(object : Callback<Movie>{
            override fun onResponse(p0: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful){
                    val movies = response.body()!!.results
                    response.body()!!.results.forEach {
                        movieList = movies
                        popularAdapter = PopularAdapter(this@HomePage, movieList)
                    }
                }
            }

            override fun onFailure(p0: Call<Movie>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}