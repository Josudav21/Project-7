package com.example.project7.api

import com.example.project7.model.PopularMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

//    https://api.themoviedb.org/3/movie/popular?api_key=ee174d364c86dd71f386a3b31d578429&page=1
//    https://api.themoviedb.org/3/movie/new?api_key=ee174d364c86dd71f386a3b31d578429&page=1
//    https://api.themoviedb.org/3/movie/trending?api_key=ee174d364c86dd71f386a3b31d578429&page=1
//    nama methodnya GET
//    popular?api_key=ee174d364c86dd71f386a3b31d578429&page=1

    @GET("popular")
    suspend fun getPopularMovies(
    @Query("api_key") apiKey: String,
    @Query("page") page: Int
    ): Response<PopularMovieResponse>
}