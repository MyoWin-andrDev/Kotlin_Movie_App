package it.ezzie.kotlin_movie_app.api

import it.ezzie.kotlin_movie_app.data.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TMDBApiService {
    @GET("movie/popular")
    fun getPopularMovie(
        @Header("Authorization") authToken : String,
        @Header("accept") accept : String = "application/json",
        @Query("language") language : String = "en-US",
        @Query("page") page : Int = 1
    ) : Call<Movie>
}