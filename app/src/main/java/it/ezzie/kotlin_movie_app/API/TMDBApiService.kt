package it.ezzie.kotlin_movie_app.API

import androidx.browser.trusted.Token
import retrofit2.http.Header
import retrofit2.http.Query

interface TMDBApiService {

    fun getPopularMovie(

        @Header("Authorization") authToken : String,
        @Header("accept") accept : String = "application/json",
        @Query("language") language : String ="en-US",
        @Query("page") page: Int = 1
    )
}