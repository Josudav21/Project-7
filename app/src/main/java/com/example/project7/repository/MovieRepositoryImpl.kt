package com.example.project7.repository

import com.example.project7.api.MovieAPI
import com.example.project7.model.PopularMovieResponse
import com.example.util.Resource

class MovieRepositoryImpl(
    private val api: MovieAPI
) : MovieRepository {

    override suspend fun getPopularMovies(
        apiKey: String,
        page: Int
    ): Resource<PopularMovieResponse> {
        return try {
            val response = api.getPopularMovies(apiKey, page)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Ok(result)
            } else {
                Resource.Failed()
            }
        } catch (e: Exception) {
            Resource.Failed()
        }
    }
}