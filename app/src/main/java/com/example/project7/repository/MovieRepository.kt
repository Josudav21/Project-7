package com.example.project7.repository

import com.example.project7.model.PopularMovieResponse
import com.example.util.Resource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieRepository {

        suspend fun getPopularMovies(
            apiKey: String,
            page: Int
        ): Resource<PopularMovieResponse>
}