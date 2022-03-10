package com.example.filmlistviewer.network

import com.example.filmlistviewer.data.MovieList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("{type}.json")
    suspend fun getMovieList(
        @Path("type") type: String,
        @Query("offset") offset: Int,
        @Query("order")order: String,
        @Query("api-key")apiKey: String
    ): MovieList
}